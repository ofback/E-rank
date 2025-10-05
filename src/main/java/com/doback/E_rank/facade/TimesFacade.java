package com.doback.E_rank.facade;

import com.doback.E_rank.application.TimesApplication;
import com.doback.E_rank.dto.CreateTeamDTO;
import com.doback.E_rank.dto.MyTeamDTO;
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
}

