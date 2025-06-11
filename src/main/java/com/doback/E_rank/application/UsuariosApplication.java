package com.doback.E_rank.application;

import com.doback.E_rank.entity.Usuarios;
import com.doback.E_rank.interfaces.PapelRepository;
import com.doback.E_rank.interfaces.UsuariosRepository;
import com.doback.E_rank.infrastructure.models.PapelModel;
import com.doback.E_rank.infrastructure.models.UsuariosModel;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UsuariosApplication {

    // Novas dependências injetadas
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

    public UsuariosModel obterUsuarioPorId(long id) {
        return usuarioRepository.searchByCode(id);
    }

    public void criarUsuario(UsuariosModel usuariosModel) {
        // --- 1. SUA LÓGICA DE VALIDAÇÃO (INTACTA) ---
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

        // --- 2. NOSSA LÓGICA DE SEGURANÇA (APLICADA APÓS VALIDAÇÕES) ---

        // Criptografa a senha do usuário
        String senhaCriptografada = passwordEncoder.encode(usuariosModel.getSenha());
        usuariosModel.setSenha(senhaCriptografada);

        // Busca o papel padrão 'ROLE_USER'
        PapelModel userRole = papelRepository.findByNome("ROLE_USER");
        if (userRole == null) {
            throw new RuntimeException("Erro crítico: Papel 'ROLE_USER' não encontrado no banco de dados.");
        }

        // Associa o papel ao usuário
        usuariosModel.setPapeis(Set.of(userRole));

        // Define o status do usuário como 'Ativo'
        usuariosModel.setSts('A');

        // --- 3. PERSISTÊNCIA ---
        // Salva o objeto 'usuariosModel' que agora contém a senha criptografada e o papel.
        usuarioRepository.addUsuarios(usuariosModel);
    }

    public void excluirUsuario(long id) {
        usuarioRepository.removeUsuarios(id);
    }

    public void atualizarUsuarios(int id, UsuariosModel usuariosModel) {
        // Lembre-se que se a atualização permitir trocar a senha,
        // a nova senha também precisará ser criptografada aqui.
        usuarioRepository.updateUsuarios((long) id, usuariosModel);
    }
}