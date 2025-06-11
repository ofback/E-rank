package com.doback.E_rank.application;
import com.doback.E_rank.entity.RegistroTimes;
import com.doback.E_rank.infrastructure.models.RegistroTimesModel;
import com.doback.E_rank.interfaces.RegistroTimesRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RegistroTimesApplication {

    private final RegistroTimesRepository registroTimesRepository;

    public RegistroTimesApplication(RegistroTimesRepository registroTimesRepository) {
        this.registroTimesRepository = registroTimesRepository;
    }

    public List<RegistroTimesModel> obterTodosRegistrosTime() {
        return registroTimesRepository.buscar();
    }

    public RegistroTimesModel obterRegistrosTime(int id) {
        return registroTimesRepository.searchByCode(id);
    }

    public void criarRegistrosTime(RegistroTimesModel registroTimesModel) {
        validar(registroTimesModel);
        registroTimesRepository.addRegistroTimes(registroTimesModel);
    }

    public void excluirRegistroTime(int id) {
        registroTimesRepository.removeRegistroTimes(id);
    }

    public void atualizarRegistrosTime(int id, RegistroTimesModel registroTimesModel) {
        validar(registroTimesModel);
        registroTimesRepository.updateRegistroTimes(id, registroTimesModel);
    }

    private RegistroTimes validar (RegistroTimesModel registroTimesModel){
        RegistroTimes registroTimesEntidade = new RegistroTimes(
                registroTimesModel.getCargo(),
                registroTimesModel.getData_entrada(),
                registroTimesModel.getIdTimes(),
                registroTimesModel.getIdUsuarios()
        );
        if (!registroTimesEntidade.validarRegistroTimes()) {
            throw new IllegalArgumentException("Validação do registroTimes falhou: " + registroTimesEntidade.getErrosValidacao());
        }

        return registroTimesEntidade;
    }

}
