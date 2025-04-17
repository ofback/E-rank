package com.doback.E_rank.facade;
import com.doback.E_rank.application.RegistroTemporadasApplication;
import com.doback.E_rank.models.RegistroTemporadas;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class RegistroTemporadasFacade {
    private final RegistroTemporadasApplication registroTemporadasApplication;

    public RegistroTemporadasFacade(RegistroTemporadasApplication registroTemporadasApplication) {
        this.registroTemporadasApplication = registroTemporadasApplication;
    }

    public List<RegistroTemporadas> listarRegistroTemporadas() {
        return registroTemporadasApplication.obterTodosRegistrosTemporadas();
    }

    public RegistroTemporadas buscarRegistroTemporadasPorId(int id) {
        return registroTemporadasApplication.obterRegistrosTemporadaPorId(id);
    }

    public void salvarRegistroTemporadas(RegistroTemporadas registroTemporadas) {
        registroTemporadasApplication.criarRegistrosTemporada(registroTemporadas);
    }

    public void excluirRegistroTemporadas(int id) {
        registroTemporadasApplication.excluirRegistrosTemporada(id);
    }

    public void atualizarRegistroTemporadas(int id, RegistroTemporadas registroTemporadas) {
        registroTemporadasApplication.atualizarRegistroTemporadas(id, registroTemporadas);
    }

}
