package com.doback.E_rank.facade;
import com.doback.E_rank.application.RegistroTimesApplication;
import com.doback.E_rank.models.RegistroTimes;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class RegistroTimesFacade {
    private final RegistroTimesApplication registroTimesApplication;

    public RegistroTimesFacade(RegistroTimesApplication registroTimesApplication) {
        this.registroTimesApplication = registroTimesApplication;
    }

    public List<RegistroTimes> listarRegistroTimes() {
        return registroTimesApplication.obterTodosRegistrosTime();
    }

    public RegistroTimes buscarRegistroTimesPorId(int id) {
        return registroTimesApplication.obterRegistrosTime(id);
    }

    public void salvarRegistroTimes(RegistroTimes registroTimes) {
        registroTimesApplication.criarRegistrosTime(registroTimes);
    }

    public void excluirRegistroTimes(int id) {
        registroTimesApplication.excluirRegistroTime(id);
    }

    public void atualizarRegistroTimes(int id, RegistroTimes times) {
        registroTimesApplication.atualizarRegistrosTime(id, times);
    }
}
