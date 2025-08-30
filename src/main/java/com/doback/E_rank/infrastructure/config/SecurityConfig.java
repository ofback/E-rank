package com.doback.E_rank.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery("""
            SELECT email, senha, CASE WHEN sts = 'A' THEN true ELSE false END as enabled
            FROM usuarios
            WHERE email = ?
        """);

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("""
            SELECT u.email, p.nome
            FROM usuarios u
            INNER JOIN usuarios_papeis up ON u.id = up.usuario_id
            INNER JOIN papeis p ON up.papel_id = p.id
            WHERE u.email = ?
        """);

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.POST, "/usuarios").permitAll()
                        .requestMatchers("/temporadas/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/usuarios").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/usuarios/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/usuarios/**").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/usuarios/**").authenticated()
                        .requestMatchers("/times/**").authenticated()
                        .requestMatchers("/amizades/**").authenticated()
                        .requestMatchers("/desafios/**").authenticated()
                        .requestMatchers("/estatisticas/**").authenticated()
                        .requestMatchers("/votacaoEstatisticas/**").authenticated() // Corrigido
                        .requestMatchers("/rankings/**").authenticated() // Novo endpoint

                        .anyRequest().authenticated()
        );


        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
