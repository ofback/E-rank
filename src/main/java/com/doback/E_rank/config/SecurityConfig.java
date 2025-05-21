package com.doback.E_rank.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class SecurityConfig {
     @Bean
     public InMemoryUserDetailsManager userDetailsManager(){
         UserDetails pedro = User.builder()
                 .username("pedro")
                 .password("{noop}pedroa@123")
                 .roles("ADMIN", "USUARIO")
                 .build();
         UserDetails gabriel = User.builder()

                 .username("gabriel")
                 .password("{noop}gabriel@123")
                 .roles("ADMIN", "USUARIO")
                 .build();
         UserDetails moab = User.builder()
                 .username("moab")
                 .password("{noop}moab@123")
                 .roles("ADMIN", "USUARIO")
                 .build();
         UserDetails joao  = User.builder()
                 .username("joao")
                 .password("{noop}joao@123")
                 .roles("ADMIN", "USUARIO")
                 .build();
         UserDetails matheus  = User.builder()
                 .username("matheus")
                 .password("{noop}matheus@123")
                 .roles("ADMIN", "USUARIO")
                 .build();


         return new InMemoryUserDetailsManager(pedro, matheus, gabriel, joao, moab);
     }
      @Bean
      public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
          httpSecurity.authorizeHttpRequests(configurer -> {
              configurer
                      .requestMatchers("/api/admin/**").hasRole("ADMIN")
                      .requestMatchers("/api/user/**").hasRole("ADMIN")
                      .requestMatchers( "/api/user/**").hasRole("USUARIO");
          });

          httpSecurity.httpBasic(Customizer.withDefaults());

          httpSecurity.csrf(csrf -> csrf.disable());

          return httpSecurity.build();
    }
}
