package com.doback.E_rank.application;
import com.doback.E_rank.entity.RegistroTimes;
import com.doback.E_rank.interfaces.RegistroTimesRepository;
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

    public RegistroTimes obterRegistrosTime(int id) {
        return registroTimesRepository.searchByCode(id);
    }

    public void criarRegistrosTime(RegistroTimes registroTimes) {
        registroTimesRepository.addRegistroTimes(registroTimes);
    }

    public void excluirRegistroTime(int id) {
        registroTimesRepository.removeRegistroTimes(id);
    }
    public void atualizarRegistrosTime(int id, RegistroTimes registroTimes) {
        registroTimesRepository.updateRegistroTimes(id, registroTimes);
    }


}
