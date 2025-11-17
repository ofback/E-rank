package com.doback.E_rank.facade;

import com.doback.E_rank.application.TimesApplication;
import com.doback.E_rank.dto.AddMemberDTO;
import com.doback.E_rank.dto.CreateTeamDTO;
import com.doback.E_rank.dto.MyTeamDTO;
import com.doback.E_rank.dto.TeamMemberDTO;
import com.doback.E_rank.infrastructure.models.TimesModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TimesFacade {
    private final TimesApplication timesApplication;

    public TimesFacade(TimesApplication timesApplication) {
        this.timesApplication = timesApplication;
    }

    // --- MÉTODOS CRUD BÁSICOS ---
    public List<TimesModel> listarTimes() {
        return timesApplication.obterTodosTimes();
    }

    public TimesModel buscarTimesPorId(int id) {
        return timesApplication.obterTimesPorId(id);
    }

    public void excluirTimes(int id) {
        timesApplication.excluirTime(id);
    }

    public void atualizarTimes(int id, TimesModel timesModel) {
        timesApplication.atualizarTimes(id, timesModel);
    }

    public void salvarTimes(CreateTeamDTO teamDTO, int creatorId) {
        timesApplication.criarTime(teamDTO, creatorId);
    }

    public List<MyTeamDTO> listarTimesDoUsuario(int userId) {
        return timesApplication.obterTimesDoUsuario(userId);
    }

    // --- NOVOS MÉTODOS RF08 ---
    public List<TeamMemberDTO> listarMembros(int timeId) {
        return timesApplication.listarMembros(timeId);
    }

    public void adicionarMembro(int timeId, int usuarioId) {
        timesApplication.adicionarMembro(timeId, usuarioId);
    }

    public void alterarCargo(int timeId, int targetUserId, String novoCargo, int requesterId) {
        timesApplication.alterarCargo(timeId, targetUserId, novoCargo, requesterId);
    }

    public void removerMembro(int timeId, int targetUserId, int requesterId) {
        timesApplication.gerenciarSaidaMembro(timeId, targetUserId, requesterId);
    }
}