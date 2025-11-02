package com.doback.E_rank.infrastructure.Security;

import com.doback.E_rank.dto.LoginRequestDTO;
import com.doback.E_rank.dto.LoginResponseDTO;
import com.doback.E_rank.infrastructure.models.UsuariosModel;
import com.doback.E_rank.infrastructure.repository.jpa.UsuariosJpa;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UsuariosJpa usuariosJpa; // Para buscar o usuário completo

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, UsuariosJpa usuariosJpa) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.usuariosJpa = usuariosJpa;

        // Define a URL que este filtro irá interceptar
        setFilterProcessesUrl("/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        try {
            // 1. Lê o JSON do corpo da requisição
            LoginRequestDTO creds = new ObjectMapper()
                    .readValue(request.getInputStream(), LoginRequestDTO.class);

            // 2. Cria o objeto de autenticação do Spring
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getEmail(),
                            creds.getSenha(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        // 1. Gera o Token
        String token = jwtTokenUtil.generateToken(authResult);

        // 2. Busca o usuário completo no banco (necessário para o DTO de resposta)
        String email = ((org.springframework.security.core.userdetails.User) authResult.getPrincipal()).getUsername();
        UsuariosModel usuario = usuariosJpa.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado após autenticação"));

        // 3. Cria o DTO de resposta (Token + Usuário)
        LoginResponseDTO loginResponse = new LoginResponseDTO(token, usuario);

        // 4. Escreve a resposta JSON para o Flutter
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new ObjectMapper().writeValueAsString(loginResponse));
        response.getWriter().flush();
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
                                              HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {
        // Retorna 401 (Unauthorized) com uma mensagem de erro
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("{\"error\": \"Falha na autenticação\", \"message\": \"Email ou senha inválidos.\"}");
    }
}