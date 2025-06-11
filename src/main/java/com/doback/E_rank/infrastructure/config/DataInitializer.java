package com.doback.E_rank.infrastructure.config;

import com.doback.E_rank.infrastructure.models.*;
import com.doback.E_rank.interfaces.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Set;

@Configuration
public class DataInitializer implements CommandLineRunner {

    // Injetando todos os repositórios que vamos usar
    private final UsuariosRepository usuariosRepository;
    private final PapelRepository papelRepository;
    private final PasswordEncoder passwordEncoder;
    private final JogosRepository jogosRepository;
    private final TemporadasRepository temporadasRepository;
    private final TimesRepository timesRepository;
    private final AmizadesRepository amizadesRepository;

    public DataInitializer(UsuariosRepository usuariosRepository, PapelRepository papelRepository, PasswordEncoder passwordEncoder, JogosRepository jogosRepository, TemporadasRepository temporadasRepository, TimesRepository timesRepository, AmizadesRepository amizadesRepository) {
        this.usuariosRepository = usuariosRepository;
        this.papelRepository = papelRepository;
        this.passwordEncoder = passwordEncoder;
        this.jogosRepository = jogosRepository;
        this.temporadasRepository = temporadasRepository;
        this.timesRepository = timesRepository;
        this.amizadesRepository = amizadesRepository;
    }

    @Override
    @Transactional // Garante que todas as operações rodem em uma única transação
    public void run(String... args) throws Exception {
        // Cada método cria um tipo de dado, na ordem correta de dependência
        createRoles();
        createAdminUser();
        createGames();
        createSeasons();
        createTestUsersAndTeams();
        createFriendships();
    }

    private void createRoles() {
        if (papelRepository.findByNome("ROLE_USER") == null) {
            PapelModel userRole = new PapelModel();
            userRole.setNome("ROLE_USER");
            papelRepository.save(userRole);
            System.out.println(">>> Papel 'ROLE_USER' criado.");
        }
        if (papelRepository.findByNome("ROLE_ADMIN") == null) {
            PapelModel adminRole = new PapelModel();
            adminRole.setNome("ROLE_ADMIN");
            papelRepository.save(adminRole);
            System.out.println(">>> Papel 'ROLE_ADMIN' criado.");
        }
    }

    private void createAdminUser() {
        if (usuariosRepository.findByEmail("admin@erank.com").isEmpty()) {
            PapelModel adminRole = papelRepository.findByNome("ROLE_ADMIN");
            PapelModel userRole = papelRepository.findByNome("ROLE_USER");

            UsuariosModel adminUser = new UsuariosModel();
            adminUser.setEmail("admin@erank.com");
            adminUser.setSenha(passwordEncoder.encode("admin123"));
            adminUser.setNome("Administrador");
            adminUser.setNickname("admin");
            adminUser.setSts('A');
            adminUser.setPapeis(Set.of(adminRole, userRole));

            usuariosRepository.addUsuarios(adminUser);
            System.out.println(">>> Usuário ADMIN 'admin@erank.com' criado com sucesso!");
        }
    }

    private void createGames() {
        if (jogosRepository.estaVazio()) { // Usando seu método 'estaVazio'
            JogosModel cs = new JogosModel("Counter-Strike 2", "Jogo de tiro tático.", "FPS");
            JogosModel fortinite = new JogosModel("Fortinite", "Battle royale de construção", "Battle Royale");
            JogosModel valorant = new JogosModel("Valorant", "Jogo de tiro tático com heróis.", "FPS");

            jogosRepository.addJogos(cs);
            jogosRepository.addJogos(fortinite);
            jogosRepository.addJogos(valorant);
            System.out.println(">>> Jogos de exemplo criados.");
        }
    }

    private void createSeasons() {
        if (temporadasRepository.estaVazio()) {
            // Criando uma data de início e fim para a temporada
            Date hoje = new Date();
            Date fimDoAno = new Date(hoje.getYear(), 11, 31); // Mês 11 é Dezembro

            TemporadasModel temporada1 = new TemporadasModel("Temporada 2025/2", "Segunda temporada do ano.", hoje, fimDoAno);

            temporadasRepository.addTemporadas(temporada1);
            System.out.println(">>> Temporada de exemplo criada.");
        }
    }

    private void createTestUsersAndTeams() {
        // Vamos criar um usuário de teste e um time para ele, apenas se ele não existir
        if (usuariosRepository.findByEmail("pedro@email.com").isEmpty()) {
            PapelModel userRole = papelRepository.findByNome("ROLE_USER");
            TemporadasModel temporada = temporadasRepository.buscar().get(0); // Pega a primeira temporada que criamos

            // Criando usuário de teste
            UsuariosModel pedro = new UsuariosModel();
            pedro.setEmail("pedro@email.com");
            pedro.setSenha(passwordEncoder.encode("pedro123"));
            pedro.setNome("Pedro Henrique");
            pedro.setNickname("phx321");
            pedro.setSts('A');
            pedro.setPapeis(Set.of(userRole));
            usuariosRepository.addUsuarios(pedro); // Salva o usuário primeiro para ele ter um ID

            // Criando um time para o usuário
            TimesModel jediOrder = new TimesModel();
            jediOrder.setNome("Ordem Jedi");
            jediOrder.setDescricao("Guardiões da paz e da justiça.");
            jediOrder.setSts('A');
            jediOrder.setIdUsuario(pedro.getId()); // Associa o usuário como dono
            jediOrder.setIdTemporada(temporada.getId()); // Associa à temporada
            timesRepository.addTimes(jediOrder);

            System.out.println(">>> Usuário de teste e Time de exemplo criados.");
        }
    }

    private void createFriendships() {
        if (usuariosRepository.findByEmail("matheus@email.com").isEmpty()) {
            PapelModel userRole = papelRepository.findByNome("ROLE_USER");

            // 1. Criar o segundo usuário
            UsuariosModel matheus = new UsuariosModel();
            matheus.setEmail("matheus@email.com");
            matheus.setSenha(passwordEncoder.encode("matheus123"));
            matheus.setNome("Matheus Amaral");
            matheus.setNickname("Matheus3074");
            matheus.setSts('A');
            matheus.setPapeis(Set.of(userRole));
            usuariosRepository.addUsuarios(matheus);

            // 2. Buscar o primeiro usuário que já existe
            UsuariosModel pedro = usuariosRepository.findByEmail("pedro@email.com").orElse(null);

            // 3. Criar a amizade se os dois usuários existirem
            if (pedro != null) {
                AmizadesModel amizade = new AmizadesModel();
                amizade.setIdUsuario1(pedro.getId());
                amizade.setIdUsuario2(matheus.getId());
                amizade.setStatus('A'); // 'A' de Aceito, por exemplo
                amizade.setDataSolicitacao(new Date().toString());
                amizadesRepository.addAmizades(amizade);

                System.out.println(">>> Usuário de teste 'Matheus' e Amizade de exemplo criados.");
            }
        }
    }
}