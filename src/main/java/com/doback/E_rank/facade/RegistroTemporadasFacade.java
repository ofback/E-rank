package com.doback.E_rank.facade;
import com.doback.E_rank.application.RegistroTemporadasApplication;
import com.doback.E_rank.infrastructure.models.RegistroTemporadasModel;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class RegistroTemporadasFacade {
    private final RegistroTemporadasApplication registroTemporadasApplication;

    public RegistroTemporadasFacade(RegistroTemporadasApplication registroTemporadasApplication) {
        this.registroTemporadasApplication = registroTemporadasApplication;
    }

    public List<RegistroTemporadasModel> listarRegistroTemporadas() {
        return registroTemporadasApplication.obterTodosRegistrosTemporadas();
    }

    public RegistroTemporadasModel buscarRegistroTemporadasPorId(int id) {
        return registroTemporadasApplication.obterRegistrosTemporadaPorId(id);
    }

    public void salvarRegistroTemporadas(RegistroTemporadasModel registroTemporadasModel) {
        registroTemporadasApplication.criarRegistrosTemporada(registroTemporadasModel);
    }

    public void excluirRegistroTemporadas(int id) {
        registroTemporadasApplication.excluirRegistrosTemporada(id);
    }

    public void atualizarRegistroTemporadas(int id, RegistroTemporadasModel registroTemporadasModel) {
        registroTemporadasApplication.atualizarRegistroTemporadas(id, registroTemporadasModel);
    }

}
