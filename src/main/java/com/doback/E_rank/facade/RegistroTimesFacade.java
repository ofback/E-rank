package com.doback.E_rank.facade;
import com.doback.E_rank.application.RegistroTimesApplication;
import com.doback.E_rank.infrastructure.models.RegistroTimesModel;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class RegistroTimesFacade {
    private final RegistroTimesApplication registroTimesApplication;

    public RegistroTimesFacade(RegistroTimesApplication registroTimesApplication) {
        this.registroTimesApplication = registroTimesApplication;
    }

    public List<RegistroTimesModel> listarRegistroTimes() {
        return registroTimesApplication.obterTodosRegistrosTime();
    }

    public RegistroTimesModel buscarRegistroTimesPorId(int id) {
        return registroTimesApplication.obterRegistrosTime(id);
    }

    public void salvarRegistroTimes(RegistroTimesModel registroTimesModel) {
        registroTimesApplication.criarRegistrosTime(registroTimesModel);
    }

    public void excluirRegistroTimes(int id) {
        registroTimesApplication.excluirRegistroTime(id);
    }

    public void atualizarRegistroTimes(int id, RegistroTimesModel times) {
        registroTimesApplication.atualizarRegistrosTime(id, times);
    }
}
