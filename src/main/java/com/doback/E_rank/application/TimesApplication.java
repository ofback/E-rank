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

    public void atualizarTimes(int id, TimesModel timesModel) {
        validar(timesModel);
        timesRepository.updateTimes(id, timesModel);
    }

    @Transactional
    public void criarTime(CreateTeamDTO teamDTO, int creatorId) {
        TemporadasModel temporadaPadrao = temporadasRepository.buscar().stream().findFirst()
                .orElseThrow(() -> new IllegalStateException("Nenhuma temporada encontrada para associar o time."));

        TimesModel timesModel = new TimesModel();
        timesModel.setNome(teamDTO.getNome());
        timesModel.setDescricao(teamDTO.getDescricao());
        timesModel.setIdUsuario(creatorId);
        timesModel.setIdTemporada(temporadaPadrao.getId());
        timesModel.setSts('A');

        validar(timesModel);
        timesRepository.addTimes(timesModel);

        String dataEntrada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        RegistroTimesModel creatorRegistration = new RegistroTimesModel();
        creatorRegistration.setIdTimes(timesModel.getId());
        creatorRegistration.setIdUsuarios(creatorId);
        creatorRegistration.setCargo("Dono");
        creatorRegistration.setStatus("A");
        creatorRegistration.setData_entrada(dataEntrada);
        registroTimesRepository.addRegistroTimes(creatorRegistration);

        if (teamDTO.getMemberIds() != null) {
            for (Integer memberId : teamDTO.getMemberIds()) {
                RegistroTimesModel memberInvitation = new RegistroTimesModel();
                memberInvitation.setIdTimes(timesModel.getId());
                memberInvitation.setIdUsuarios(memberId);
                memberInvitation.setCargo("Membro");
                memberInvitation.setStatus("P");
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

    // --- NOVAS FUNCIONALIDADES (RF08) ---

    // 1. Listar Membros
    public List<TeamMemberDTO> listarMembros(int timeId) {
        return registroTimesJpa.findByIdTimes(timeId).stream()
                .map(reg -> new TeamMemberDTO(
                        reg.getUsuariosModel().getId(),
                        reg.getUsuariosModel().getNickname(),
                        reg.getCargo(),
                        reg.getData_entrada()
                ))
                .collect(Collectors.toList());
    }

    // 2. Adicionar Membro (Pós-criação)
    @Transactional
    public void adicionarMembro(int timeId, int usuarioId) {
        if (registroTimesJpa.findByIdTimesAndIdUsuarios(timeId, usuarioId).isPresent()) {
            throw new IllegalArgumentException("Usuário já está no time.");
        }

        RegistroTimesModel novoMembro = new RegistroTimesModel();
        novoMembro.setIdTimes(timeId);
        novoMembro.setIdUsuarios(usuarioId);
        novoMembro.setCargo("Membro");
        novoMembro.setStatus("A");
        novoMembro.setData_entrada(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        registroTimesRepository.addRegistroTimes(novoMembro);
    }

    // 3. Alterar Cargo (Ex: Membro -> ViceLider)
    @Transactional
    public void alterarCargo(int timeId, int targetUserId, String novoCargo, int requesterId) {
        RegistroTimesModel requester = registroTimesJpa.findByIdTimesAndIdUsuarios(timeId, requesterId)
                .orElseThrow(() -> new ResourceNotFoundException("Você não faz parte deste time."));

        // Apenas Dono pode promover
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

    // 4. Remover Membro (Substitui e expande o antigo leaveTeam)
    @Transactional
    public void gerenciarSaidaMembro(int timeId, int targetUserId, int requesterId) {
        RegistroTimesModel requester = registroTimesJpa.findByIdTimesAndIdUsuarios(timeId, requesterId)
                .orElseThrow(() -> new ResourceNotFoundException("Solicitante não encontrado no time."));

        RegistroTimesModel target = registroTimesJpa.findByIdTimesAndIdUsuarios(timeId, targetUserId)
                .orElseThrow(() -> new ResourceNotFoundException("Membro alvo não encontrado."));

        // Caso 1: Sair do time (Auto-remoção)
        if (requesterId == targetUserId) {
            if ("Dono".equalsIgnoreCase(target.getCargo())) {
                throw new IllegalStateException("O Dono não pode sair. Transfira a liderança ou delete o time.");
            }
            registroTimesJpa.delete(target);
            return;
        }

        // Caso 2: Expulsão (Kick)
        boolean isRequesterBoss = "Dono".equalsIgnoreCase(requester.getCargo()) || "ViceLider".equalsIgnoreCase(requester.getCargo());

        if (!isRequesterBoss) {
            throw new IllegalStateException("Você não tem permissão para remover membros.");
        }

        if ("Dono".equalsIgnoreCase(target.getCargo())) {
            throw new IllegalStateException("Ninguém pode expulsar o Dono.");
        }

        // Opcional: Vice não expulsa Vice
        if ("ViceLider".equalsIgnoreCase(requester.getCargo()) && "ViceLider".equalsIgnoreCase(target.getCargo())) {
            throw new IllegalStateException("Vice-Líder não pode expulsar outro Vice-Líder.");
        }

        registroTimesJpa.delete(target);
    }

    // Mantido por compatibilidade, mas delegando para a nova lógica
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
            throw new IllegalArgumentException("Validação do time falhou: " + timesEntidade.getErrosValidacao());
        }
    }
}