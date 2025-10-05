package com.doback.E_rank.facade;

import com.doback.E_rank.application.AmizadesApplication;
import com.doback.E_rank.dto.FriendDTO;
import com.doback.E_rank.dto.PendingRequestDTO;
import com.doback.E_rank.infrastructure.models.AmizadesModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AmizadesFacade {

    private final AmizadesApplication amizadeApplication;

    public AmizadesFacade(AmizadesApplication amizadeApplication) {
        this.amizadeApplication = amizadeApplication;
    }

    // Métodos existentes que não mudaram
    public List<AmizadesModel> listarAmizades() {
        return amizadeApplication.obterTodasAmizades();
    }

    public AmizadesModel buscarAmizadePorId(int id) {
        return amizadeApplication.obterAmizadePorId(id);
    }

    public void salvarAmizade(int idRemetente, int idDestinatario) {
        amizadeApplication.criarAmizade(idRemetente, idDestinatario);
    }

    public void excluirAmizade(int id) {
        amizadeApplication.excluirAmizade(id);
    }

    public void atualizarAmizades(int id, AmizadesModel amizadesModel) {
        amizadeApplication.atualizarAmizades(id, amizadesModel);
    }

    // Métodos atualizados com os novos tipos de retorno (DTOs)
    public List<FriendDTO> listarAmigos(int idUsuarioLogado) {
        return amizadeApplication.listarAmigos(idUsuarioLogado);
    }

    public List<PendingRequestDTO> listarConvitesPendentes(int idUsuarioLogado) {
        return amizadeApplication.listarConvitesPendentes(idUsuarioLogado);
    }
}
