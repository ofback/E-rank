package com.doback.E_rank.facade;

import com.doback.E_rank.application.UsuariosApplication;
import com.doback.E_rank.dto.CreateUsuarioDTO;
import com.doback.E_rank.dto.UpdateProfileDTO;
import com.doback.E_rank.dto.UsuarioResponseDTO;
import com.doback.E_rank.infrastructure.models.UsuariosModel;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuariosFacade {
    private final UsuariosApplication usuarioApplication;

    public UsuariosFacade(UsuariosApplication usuarioApplication) {
        this.usuarioApplication = usuarioApplication;
    }

    // --- CONVERSOR DE SEGURANÇA (MODEL -> DTO) ---
    private UsuarioResponseDTO toDTO(UsuariosModel model) {
        return new UsuarioResponseDTO(
                model.getId(),
                model.getNome(),
                model.getNickname(),
                model.getEmail(),
                model.getBiografia(),
                model.getDataCriacao()
        );
    }

    public List<UsuarioResponseDTO> listarUsuarios() {
        return usuarioApplication.obterTodosUsuarios().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public UsuarioResponseDTO buscarUsuarioPorId(int id) {
        return toDTO(usuarioApplication.obterUsuarioPorId(id));
    }

    public UsuarioResponseDTO buscarUsuarioPorEmail(String email) {
        return toDTO(usuarioApplication.obterUsuarioPorEmail(email));
    }

    public List<UsuarioResponseDTO> listarUsuariosPorNickname(String nickname) {
        return usuarioApplication.obterUsuariosPorNickname(nickname).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // --- CRIAÇÃO SEGURA (DTO -> MODEL) ---
    public void salvarUsuario(CreateUsuarioDTO dto) {
        UsuariosModel model = new UsuariosModel();

        // Mapeia apenas o que vem do cadastro seguro
        model.setNome(dto.getNome());
        model.setNickname(dto.getNickname());
        model.setEmail(dto.getEmail());
        model.setSenha(dto.getSenha());
        model.setCpf(dto.getCpf());
        model.setDataNascimento(dto.getDataNascimento());

        // Define valores de sistema (que o usuário não pode manipular)
        model.setSts('A');
        model.setDataCriacao(new Date());

        usuarioApplication.criarUsuario(model);
    }

    public void excluirUsuario(int id) {
        usuarioApplication.excluirUsuario(id);
    }

    public void atualizarUsuarios(int id, UsuariosModel usuariosModel) {
        usuarioApplication.atualizarUsuarios(id, usuariosModel);
    }

    public void atualizarPerfil(String email, UpdateProfileDTO profileDTO) {
        usuarioApplication.atualizarPerfil(email, profileDTO);
    }
}