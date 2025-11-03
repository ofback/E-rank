package com.doback.E_rank.infrastructure.config;

import com.doback.E_rank.infrastructure.repository.jpa.UsuariosJpa;
import com.doback.E_rank.infrastructure.Security.JwtAuthenticationFilter;
import com.doback.E_rank.infrastructure.Security.JwtAuthorizationFilter;
import com.doback.E_rank.infrastructure.Security.JwtTokenUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.Arrays;
import static org.springframework.security.config.Customizer.withDefaults;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Injeções para os novos filtros
    private final JwtTokenUtil jwtTokenUtil;


    public SecurityConfig(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

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

    // Bean OBRIGATÓRIO para o filtro de autenticação
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager, UserDetailsManager userDetailsManager, UsuariosJpa usuariosJpa) throws Exception {

        http.cors(cors -> cors.configurationSource(corsConfigurationSource()));

        // 1. Desabilitar CSRF (comum em APIs stateless)
        http.csrf(csrf -> csrf.disable());

        // 2. Definir a política de sessão como STATELESS (não guardar estado)
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // 3. Configurar as permissões de rotas (authorizeHttpRequests)
        http.authorizeHttpRequests(configurer ->
                configurer
                        // Permite cadastro e login sem autenticação
                        .requestMatchers(HttpMethod.POST, "/usuarios").permitAll()
                        .requestMatchers(HttpMethod.POST, "/login").permitAll()

                        // Protege as rotas de admin
                        .requestMatchers("/temporadas/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/usuarios").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/usuarios/**").hasRole("ADMIN")

                        // Exige autenticação para todo o resto
                        .requestMatchers(HttpMethod.GET, "/usuarios/**").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/usuarios/**").authenticated()
                        .requestMatchers("/times/**").authenticated()
                        .requestMatchers("/amizades/**").authenticated()
                        .requestMatchers("/desafios/**").authenticated()
                        .requestMatchers("/estatisticas/**").authenticated()
                        .requestMatchers("/votacaoEstatisticas/**").authenticated()
                        .requestMatchers("/rankings/**").authenticated()
                        .anyRequest().authenticated()
        );

        // 4. Adicionar os filtros JWT
        // Adiciona o filtro de autenticação (só para /login)
        http.addFilter(new JwtAuthenticationFilter(authenticationManager, jwtTokenUtil, usuariosJpa));

        // Adiciona o filtro de autorização (para todas as outras rotas)
        // (Esta linha também usa os parâmetros passados para o método)
        http.addFilterBefore(new JwtAuthorizationFilter(jwtTokenUtil, userDetailsManager), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // Permite requisições da origem do seu front-end
        configuration.setAllowedOrigins(Arrays.asList("http://localhost", "http://127.0.0.1"));

        // Permite os métodos HTTP
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD"));

        // Permite todos os cabeçalhos (incluindo 'Authorization' para o JWT)
        configuration.setAllowedHeaders(Arrays.asList("*"));

        // Permite credenciais (cookies, se houver)
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // Aplica para todas as rotas
        return source;
    }
}
