// E-rank/src/main/java/com/doback/E_rank/application/TimesApplication.java
package com.doback.E_rank.application;

import com.doback.E_rank.dto.CreateTeamDTO;
import com.doback.E_rank.dto.MyTeamDTO;
import com.doback.E_rank.dto.TeamMemberDTO;
import com.doback.E_rank.entity.Times;
import com.doback.E_rank.exceptions.ResourceNotFoundException;
import com.doback.E_rank.infrastructure.models.RegistroTimesModel;
import com.doback.E_rank.infrastructure.models.TemporadasModel;
import com.doback.E_rank.infrastructure.models.TimesModel;
import com.doback.E_rank.infrastructure.repository.jpa.RegistroTimesJpa;
import com.doback.E_rank.interfaces.RegistroTimesRepository;
import com.doback.E_rank.interfaces.TemporadasRepository;
import com.doback.E_rank.interfaces.TimesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimesApplication {

    private final TimesRepository timesRepository;
    private final TemporadasRepository temporadasRepository;
    private final RegistroTimesRepository registroTimesRepository;
    private final RegistroTimesJpa registroTimesJpa;

    public TimesApplication(TimesRepository timesRepository, TemporadasRepository temporadasRepository, RegistroTimesRepository registroTimesRepository, RegistroTimesJpa registroTimesJpa) {
        this.timesRepository = timesRepository;
        this.temporadasRepository = temporadasRepository;
        this.registroTimesRepository = registroTimesRepository;
        this.registroTimesJpa = registroTimesJpa;
    }

    public List<TimesModel> obterTodosTimes() {
        return timesRepository.buscar();
    }

    public TimesModel obterTimesPorId(int id) {
        return timesRepository.searchByCode(id);
    }

    public void excluirTime(int id) {
        timesRepository.removeTimes(id);
    }

    // --- ALTERAÇÃO AQUI: Lógica de Merge para Atualização Segura ---
    public void atualizarTimes(int id, TimesModel dadosAtualizados) {
        // 1. Busca o time existente
        TimesModel timeExistente = timesRepository.searchByCode(id);
        if (timeExistente == null) {
            throw new ResourceNotFoundException("Time não encontrado com ID: " + id);
        }

        // 2. Atualiza apenas os campos permitidos (Nome e Descrição)
        // Mantém o ID, Dono, Temporada e Status originais
        if (dadosAtualizados.getNome() != null) {
            timeExistente.setNome(dadosAtualizados.getNome());
        }
        if (dadosAtualizados.getDescricao() != null) {
            timeExistente.setDescricao(dadosAtualizados.getDescricao());
        }

        // 3. Valida o objeto completo (agora com os dados mesclados)
        validar(timeExistente);

        // 4. Persiste
        timesRepository.updateTimes(id, timeExistente);
    }

    @Transactional
    public void criarTime(CreateTeamDTO teamDTO, int creatorId) {
        TemporadasModel temporadaPadrao = temporadasRepository.buscar().stream().findFirst()
                .orElseThrow(() -> new IllegalStateException("Nenhuma temporada encontrada."));

        TimesModel timesModel = new TimesModel();
        timesModel.setNome(teamDTO.getNome());
        timesModel.setDescricao(teamDTO.getDescricao());
        timesModel.setIdUsuario(creatorId);
        timesModel.setIdTemporada(temporadaPadrao.getId());
        timesModel.setSts('A');

        validar(timesModel);
        timesRepository.addTimes(timesModel);

        String dataEntrada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        // Criador entra como DONO e ATIVO
        RegistroTimesModel creatorRegistration = new RegistroTimesModel();
        creatorRegistration.setIdTimes(timesModel.getId());
        creatorRegistration.setIdUsuarios(creatorId);
        creatorRegistration.setCargo("Dono");
        creatorRegistration.setStatus("A");
        creatorRegistration.setData_entrada(dataEntrada);
        registroTimesRepository.addRegistroTimes(creatorRegistration);

        // Convidados entram como MEMBRO e PENDENTE
        if (teamDTO.getMemberIds() != null) {
            for (Integer memberId : teamDTO.getMemberIds()) {
                RegistroTimesModel memberInvitation = new RegistroTimesModel();
                memberInvitation.setIdTimes(timesModel.getId());
                memberInvitation.setIdUsuarios(memberId);
                memberInvitation.setCargo("Membro");
                memberInvitation.setStatus("P"); // Pendente
                memberInvitation.setData_entrada(dataEntrada);
                registroTimesRepository.addRegistroTimes(memberInvitation);
            }
        }
    }

    @Transactional(readOnly = true)
    public List<MyTeamDTO> obterTimesDoUsuario(int userId) {
        return registroTimesJpa.findByIdUsuarios(userId).stream()
                .filter(registro -> registro.getTimesModel() != null)
                .filter(registro -> registro.getTimesModel().getNome() != null)
                .map(registro -> new MyTeamDTO(
                        registro.getIdTimes(),
                        registro.getTimesModel().getNome(),
                        registro.getCargo(),
                        registro.getStatus()
                ))
                .collect(Collectors.toList());
    }

    // --- MÉTODOS RF08 (Gerenciamento) ---

    public List<TeamMemberDTO> listarMembros(int timeId) {
        return registroTimesJpa.findByIdTimes(timeId).stream()
                .map(reg -> new TeamMemberDTO(
                        reg.getUsuariosModel().getId(),
                        reg.getUsuariosModel().getNickname(),
                        reg.getCargo(),
                        reg.getData_entrada(),
                        reg.getStatus()
                ))
                .collect(Collectors.toList());
    }

    @Transactional
    public void adicionarMembro(int timeId, int usuarioId) {
        if (registroTimesJpa.findByIdTimesAndIdUsuarios(timeId, usuarioId).isPresent()) {
            throw new IllegalArgumentException("Usuário já está no time.");
        }

        RegistroTimesModel novoMembro = new RegistroTimesModel();
        novoMembro.setIdTimes(timeId);
        novoMembro.setIdUsuarios(usuarioId);
        novoMembro.setCargo("Membro");
        novoMembro.setStatus("P"); // Entra como Pendente ao ser adicionado
        novoMembro.setData_entrada(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        registroTimesRepository.addRegistroTimes(novoMembro);
    }

    @Transactional
    public void responderConvite(int timeId, int userId, boolean aceitar) {
        RegistroTimesModel convite = registroTimesJpa.findByIdTimesAndIdUsuarios(timeId, userId)
                .orElseThrow(() -> new ResourceNotFoundException("Convite não encontrado."));

        if (!"P".equals(convite.getStatus())) {
            // Se já for Ativo, apenas ignora ou retorna erro. Vamos permitir idempotência.
            if ("A".equals(convite.getStatus()) && aceitar) return;
            throw new IllegalStateException("Este registro não está pendente.");
        }

        if (aceitar) {
            convite.setStatus("A");
            registroTimesJpa.save(convite);
        } else {
            registroTimesJpa.delete(convite);
        }
    }

    @Transactional
    public void alterarCargo(int timeId, int targetUserId, String novoCargo, int requesterId) {
        RegistroTimesModel requester = registroTimesJpa.findByIdTimesAndIdUsuarios(timeId, requesterId)
                .orElseThrow(() -> new ResourceNotFoundException("Você não faz parte do time."));

        if (!"Dono".equalsIgnoreCase(requester.getCargo())) {
            throw new IllegalStateException("Apenas o Dono pode alterar cargos.");
        }

        RegistroTimesModel target = registroTimesJpa.findByIdTimesAndIdUsuarios(timeId, targetUserId)
                .orElseThrow(() -> new ResourceNotFoundException("Membro alvo não encontrado."));

        if ("Dono".equalsIgnoreCase(target.getCargo())) {
            throw new IllegalArgumentException("O cargo do Dono não pode ser alterado.");
        }

        target.setCargo(novoCargo);
        registroTimesJpa.save(target);
    }

    @Transactional
    public void gerenciarSaidaMembro(int timeId, int targetUserId, int requesterId) {
        RegistroTimesModel requester = registroTimesJpa.findByIdTimesAndIdUsuarios(timeId, requesterId)
                .orElseThrow(() -> new ResourceNotFoundException("Solicitante não encontrado no time."));

        RegistroTimesModel target = registroTimesJpa.findByIdTimesAndIdUsuarios(timeId, targetUserId)
                .orElseThrow(() -> new ResourceNotFoundException("Membro alvo não encontrado."));

        // Sair por conta própria
        if (requesterId == targetUserId) {
            if ("Dono".equalsIgnoreCase(target.getCargo())) {
                throw new IllegalStateException("O Dono não pode sair. Transfira a liderança ou delete o time.");
            }
            registroTimesJpa.delete(target);
            return;
        }

        // Expulsão
        boolean isRequesterBoss = "Dono".equalsIgnoreCase(requester.getCargo()) || "ViceLider".equalsIgnoreCase(requester.getCargo());

        if (!isRequesterBoss) {
            throw new IllegalStateException("Sem permissão para remover membros.");
        }

        if ("Dono".equalsIgnoreCase(target.getCargo())) {
            throw new IllegalStateException("Ninguém pode expulsar o Dono.");
        }

        if ("ViceLider".equalsIgnoreCase(requester.getCargo()) && "ViceLider".equalsIgnoreCase(target.getCargo())) {
            throw new IllegalStateException("Vice-Líder não pode expulsar outro Vice-Líder.");
        }

        registroTimesJpa.delete(target);
    }

    @Transactional
    public void leaveTeam(int teamId, int userId) {
        gerenciarSaidaMembro(teamId, userId, userId);
    }

    private void validar(TimesModel timesModel) {
        Times timesEntidade = new Times(
                timesModel.getNome(),
                timesModel.getDescricao(),
                timesModel.getSts(),
                timesModel.getIdTemporada(),
                timesModel.getIdUsuario()
        );

        if (!timesEntidade.validarTime()) {
            throw new IllegalArgumentException("Validação falhou: " + timesEntidade.getErrosValidacao());
        }
    }
}