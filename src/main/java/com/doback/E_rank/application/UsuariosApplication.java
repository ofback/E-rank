package com.doback.E_rank.application;


import com.doback.E_rank.entity.Usuarios;
import com.doback.E_rank.models.UsuariosModel;
import com.doback.E_rank.interfaces.UsuariosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosApplication {
    private final UsuariosRepository usuarioRepository;

    public UsuariosApplication(UsuariosRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuariosModel> obterTodosUsuarios() {
        return usuarioRepository.buscar();
    }

    public UsuariosModel obterUsuarioPorId(long id) {
        return usuarioRepository.searchByCode(id);
    }

    public void criarUsuario(UsuariosModel usuariosModel) {
        Usuarios usuarioEntidade = new Usuarios(
                usuariosModel.getNome(),
                usuariosModel.getCpf(),
                usuariosModel.getDataNascimento(),
                usuariosModel.getEmail(),
                usuariosModel.getNickname(),
                usuariosModel.getSenha(),
                usuariosModel.getBiografia(),
                usuariosModel.getSts(),
                usuariosModel.getDataCriacao()
        );

        if (!usuarioEntidade.validarCPF()) {
            throw new IllegalArgumentException("CPF inválido.");
        }

        if (!usuarioEntidade.validarEmail()) {
            throw new IllegalArgumentException("Email inválido.");
        }

        if (usuarioEntidade.calcularIdade() < 13) {
            throw new IllegalArgumentException("Usuário precisa ter pelo menos 13 anos.");
        }

        usuarioRepository.addUsuarios(usuariosModel);
    }

    public void excluirUsuario(long id) {
        usuarioRepository.removeUsuarios(id);
    }

    public void atualizarUsuarios(int id, UsuariosModel usuariosModel) {
        usuarioRepository.updateUsuarios((long) id, usuariosModel);
    }
}
