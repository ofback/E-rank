package com.doback.E_rank.repository;
import com.doback.E_rank.entity.RegistroTemporadas;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RegistroTemporadasRepository {
    private List<RegistroTemporadas> registroTemporadas = new ArrayList<>();

    public RegistroTemporadas buscarPorId(long code) {
        RegistroTemporadas registroTemporada = registroTemporadas
                .stream()
                .filter(p -> p.getId_registro_temporadas() == code)
                .findFirst()
                .get();

        return registroTemporada;
    }

    public List<RegistroTemporadas> buscar(){
        return registroTemporadas;
    }

    public void adicionar(RegistroTemporadas registroTemporada) {
        registroTemporadas.add(registroTemporada);
    }

    public void remover(long code){
        registroTemporadas.removeIf(p -> p.getId_registro_temporadas() == code);
    }
}
