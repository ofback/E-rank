package com.doback.E_rank.application;

import com.doback.E_rank.dto.CreateTeamDTO;
import com.doback.E_rank.entity.Times;
import com.doback.E_rank.infrastructure.models.RegistroTimesModel;
import com.doback.E_rank.infrastructure.models.TemporadasModel;
import com.doback.E_rank.infrastructure.models.TimesModel;
import com.doback.E_rank.interfaces.RegistroTimesRepository;
import com.doback.E_rank.interfaces.TemporadasRepository;
import com.doback.E_rank.interfaces.TimesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TimesApplication {

    private final TimesRepository timesRepository;
    private final TemporadasRepository temporadasRepository;
    private final RegistroTimesRepository registroTimesRepository;

    public TimesApplication(TimesRepository timesRepository, TemporadasRepository temporadasRepository, RegistroTimesRepository registroTimesRepository) {
        this.timesRepository = timesRepository;
        this.temporadasRepository = temporadasRepository;
        this.registroTimesRepository = registroTimesRepository;
    }

    // --- MÉTODOS CRUD QUE ESTAVAM FALTANDO ---
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
    // --- FIM DOS MÉTODOS FALTANTES ---

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
        timesRepository.addTimes(timesModel); // Salva o time para obter o ID gerado

        // 1. Adiciona o criador como 'Dono' do time
        RegistroTimesModel creatorRegistration = new RegistroTimesModel();
        creatorRegistration.setIdTimes(timesModel.getId());
        creatorRegistration.setIdUsuarios(creatorId);
        creatorRegistration.setCargo("Dono");

        // Verifique o tipo do campo 'status' no seu RegistroTimesModel.
        // Se for 'char', use a linha abaixo.
        // creatorRegistration.setStatus('A');

        // Se for 'String', como no arquivo que você enviou, use esta:
        // creatorRegistration.setStatus("A");

        registroTimesRepository.addRegistroTimes(creatorRegistration);

        // 2. Envia convites para os membros selecionados
        if (teamDTO.getMemberIds() != null) {
            for (Integer memberId : teamDTO.getMemberIds()) {
                RegistroTimesModel memberInvitation = new RegistroTimesModel();
                memberInvitation.setIdTimes(timesModel.getId());
                memberInvitation.setIdUsuarios(memberId);
                memberInvitation.setCargo("Membro");
                // Da mesma forma, ajuste o status para 'P' ou "P" conforme o tipo do campo
                // memberInvitation.setStatus("P");
                registroTimesRepository.addRegistroTimes(memberInvitation);
            }
        }
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

