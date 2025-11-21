package com.doback.E_rank.application;

import com.doback.E_rank.entity.Usuarios;
import com.doback.E_rank.interfaces.PapelRepository;
import com.doback.E_rank.interfaces.UsuariosRepository;
import com.doback.E_rank.infrastructure.models.PapelModel;
import com.doback.E_rank.infrastructure.models.UsuariosModel;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.doback.E_rank.dto.UpdateProfileDTO;

import java.util.List;
import java.util.Set;

@Service
public class UsuariosApplication {

    private final UsuariosRepository usuarioRepository;
    private final PapelRepository papelRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuariosApplication(UsuariosRepository usuarioRepository, PapelRepository papelRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.papelRepository = papelRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UsuariosModel> obterTodosUsuarios() {
        return usuarioRepository.buscar();
    }

    public UsuariosModel obterUsuarioPorId(int id) {
        return usuarioRepository.searchByCode(id);
    }

    public void criarUsuario(UsuariosModel usuariosModel) {
        // 1. Validação das Regras de Negócio (Extraído para método privado)
        validarRegrasDeNegocio(usuariosModel);

        // 2. Lógica de Segurança
        String senhaCriptografada = passwordEncoder.encode(usuariosModel.getSenha());
        usuariosModel.setSenha(senhaCriptografada);

        PapelModel userRole = papelRepository.findByNome("ROLE_USER");
        if (userRole == null) {
            throw new RuntimeException("Erro crítico: Papel 'ROLE_USER' não encontrado no banco de dados.");
        }

        usuariosModel.setPapeis(Set.of(userRole));
        usuariosModel.setSts('A');

        // 3. Persistência
        usuarioRepository.addUsuarios(usuariosModel);
    }

    public void excluirUsuario(int id) {
        usuarioRepository.removeUsuarios(id);
    }

    public void atualizarUsuarios(int id, UsuariosModel usuariosModel) {
        // CORREÇÃO: Removido o cast (int) redundante
        usuarioRepository.updateUsuarios(id, usuariosModel);
    }

    public UsuariosModel obterUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o email: " + email));
    }

    public void atualizarPerfil(String email, UpdateProfileDTO profileDTO) {
        UsuariosModel usuarioExistente = obterUsuarioPorEmail(email);

        usuarioExistente.setNickname(profileDTO.getNickname());
        usuarioExistente.setBiografia(profileDTO.getBiografia());

        // CORREÇÃO: Removido o cast (int) redundante
        usuarioRepository.updateUsuarios(usuarioExistente.getId(), usuarioExistente);
    }

    public List<UsuariosModel> obterUsuariosPorNickname(String nickname) {
        return usuarioRepository.findByNickname(nickname);
    }

    // --- MÉTODOS PRIVADOS ---

    private void validarRegrasDeNegocio(UsuariosModel usuariosModel) {
        // Converte para a Entidade de Domínio para validar
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
        if (usuarioRepository.findByEmail(usuariosModel.getEmail()).isPresent()) {
            throw new IllegalStateException("Erro: Email já cadastrado.");
        }
    }
}