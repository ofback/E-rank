package com.doback.E_rank.facade;
import com.doback.E_rank.application.RegistroTimesApplication;
import com.doback.E_rank.entity.RegistroTimes;
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

    public RegistroTimes buscarRegistroTimesPorId(Long id) {
        return registroTimesApplication.obterRegistrosTime(id);
    }

    public void salvarRegistroTimes(RegistroTimes registroTimes) {
        registroTimesApplication.criarRegistrosTime(registroTimes);
    }

    public void excluirRegistroTimes(Long id) {
        registroTimesApplication.excluirRegistroTime(id);
    }

    public void atualizarRegistroTimes(Long id, RegistroTimes times) {
        registroTimesApplication.atualizarRegistrosTime(id, times);
    }
}
