package com.doback.E_rank.repository;
import com.doback.E_rank.entity.RegistroTimes;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RegistroTimesRepository {
    private List<RegistroTimes> registroTimes = new ArrayList<>();

    public RegistroTimes buscarPorId(long code) {
        RegistroTimes registroTime = registroTimes
                .stream()
                .filter(p -> p.getId_registro_times() == code)
                .findFirst()
                .get();

        return registroTime;
    }

    public List<RegistroTimes> buscar(){
        return registroTimes;
    }

    public void adicionar(RegistroTimes registroTimes) {
        registroTimes.add(registroTimes);
    }

    public void remover(long code){
        registroTimes.removeIf(p -> p.getId_registro_times() == code);
    }

    public void atualizar(Long id, RegistroTimes novoRegistroTime) {
        RegistroTimes registroTimeExistente = buscarPorId(id);
        if (registroTimeExistente != null) {
            registroTimeExistente.setCargo(novoRegistroTime.getCargo());
            registroTimeExistente.setData_entrada(novoRegistroTime.getData_entrada());
        }
    }

}
