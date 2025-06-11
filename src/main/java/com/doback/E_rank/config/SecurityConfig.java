package com.doback.E_rank.config;

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

    // Bean que ensina o Spring Security a buscar os usuários no SEU banco de dados
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // Query para buscar um usuário pelo email.
        // O Spring Security espera as colunas: username, password, enabled
        jdbcUserDetailsManager.setUsersByUsernameQuery("""
            SELECT email, senha, CASE WHEN sts = 'A' THEN true ELSE false END as enabled
            FROM usuarios
            WHERE email = ?
        """);

        // Query para buscar os papéis (authorities) de um usuário pelo email.
        // O Spring Security espera as colunas: username, authority
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("""
            SELECT u.email, p.nome
            FROM usuarios u
            INNER JOIN usuarios_papeis up ON u.id = up.usuario_id
            INNER JOIN papeis p ON up.papel_id = p.id
            WHERE u.email = ?
        """);

        return jdbcUserDetailsManager;
    }

    // Bean que define a cadeia de filtros de segurança (quais endpoints proteger e como)
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        // == ACESSO PÚBLICO ==
                        // Qualquer pessoa pode se cadastrar. Esta é a ÚNICA rota de usuário que é pública.
                        .requestMatchers(HttpMethod.POST, "/usuarios").permitAll()

                        // == ACESSO DE ADMINISTRADOR ==
                        .requestMatchers("/temporadas/**").hasRole("ADMIN")
                        // Apenas admins podem ver a lista de TODOS os usuários.
                        .requestMatchers(HttpMethod.GET, "/usuarios").hasRole("ADMIN")
                        // Apenas admins podem deletar um usuário.
                        .requestMatchers(HttpMethod.DELETE, "/usuarios/**").hasRole("ADMIN")

                        // == ACESSO DE USUÁRIO LOGADO (USER) ==
                        // Um usuário logado pode ver o perfil de outro ou atualizar o seu.
                        .requestMatchers(HttpMethod.GET, "/usuarios/**").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/usuarios/**").authenticated()

                        // Regras para as outras entidades (times, amizades, etc.)
                        .requestMatchers("/times/**").authenticated()
                        .requestMatchers("/amizades/**").authenticated()
                        .requestMatchers("/desafios/**").authenticated()
                        .requestMatchers("/estatisticas/**").authenticated()
                        .requestMatchers("/votacoes/**").authenticated()

                        // Qualquer outra requisição que não foi mencionada acima precisa de autenticação.
                        .anyRequest().authenticated()
        );

        // Habilita a autenticação via Basic Auth
        http.httpBasic(Customizer.withDefaults());

        // Desabilita o CSRF
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
