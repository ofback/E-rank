package com.doback.E_rank.application;
import com.doback.E_rank.entity.RegistroTimes;
import com.doback.E_rank.facade.RegistroTimesFacade;
import com.doback.E_rank.repository.RegistroTimesRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RegistroTimesApplication {

    private final RegistroTimesRepository registroTimesRepository;

    public RegistroTimesApplication(RegistroTimesRepository registroTimesRepository) {
        this.registroTimesRepository = registroTimesRepository;
    }

    public List<RegistroTimes> obterTodosRegistrosTime() {
        return registroTimesRepository.buscar();
    }

    public RegistroTimes obterRegistrosTime(long id) {
        return registroTimesRepository.buscarPorId(id);
    }

    public void criarRegistrosTime(RegistroTimes registroTimes) {
        registroTimesRepository.adicionar(registroTimes);
    }

    public void excluirRegistroTime(Long id) {
        registroTimesRepository.remover(id);
    }
    public void atualizarRegistrosTime(Long id, RegistroTimes registroTimes) {
        registroTimesRepository.atualizar(id, registroTimes);
    }


}
