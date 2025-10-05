package com.doback.E_rank.infrastructure.repository.jpa;

import com.doback.E_rank.infrastructure.models.AmizadesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List; // Importar a List

public interface AmizadesJpa extends JpaRepository<AmizadesModel, Integer> {
    // Encontra amizades onde o usuário logado é o solicitante (usuario1) OU o solicitado (usuario2)
    // e o status é o que foi passado como parâmetro.
    List<AmizadesModel> findByIdUsuario1AndStatusOrIdUsuario2AndStatus(int idUsuario1, char status1, int idUsuario2, char status2);

    // Encontra amizades onde o usuário logado é o solicitado (usuario2) e o status é pendente
    List<AmizadesModel> findByIdUsuario2AndStatus(int idUsuario2, char status);
}