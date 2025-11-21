// E-rank/src/main/java/com/doback/E_rank/facade/DesafiosFacade.java
package com.doback.E_rank.facade;

import com.doback.E_rank.application.DesafiosApplication;
import com.doback.E_rank.dto.CreateDesafioDTO;
import com.doback.E_rank.dto.DesafioResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DesafiosFacade {
    private final DesafiosApplication desafiosApplication;

    public DesafiosFacade(DesafiosApplication desafiosApplication) {
        this.desafiosApplication = desafiosApplication;
    }

    public void criar(CreateDesafioDTO dto, int desafianteId) {
        desafiosApplication.criarDesafio(dto, desafianteId);
    }

    public List<DesafioResponseDTO> listarPendentes(int userId) {
        return desafiosApplication.listarPendentes(userId);
    }

    public void responder(int desafioId, int userId, boolean aceitar) {
        desafiosApplication.responderDesafio(desafioId, userId, aceitar);
    }
    public List<DesafioResponseDTO> listarAceitos(int userId) {
        return desafiosApplication.listarAceitos(userId);
    }
}