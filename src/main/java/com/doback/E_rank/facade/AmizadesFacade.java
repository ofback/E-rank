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

    public List<AmizadesModel> listarAmizades() {
        return amizadeApplication.obterTodasAmizades();
    }

    public AmizadesModel buscarAmizadePorId(int id) {
        return amizadeApplication.obterAmizadePorId(id);
    }

    public void salvarAmizade(int idRemetente, int idDestinatario) {
        amizadeApplication.criarAmizade(idRemetente, idDestinatario);
    }

    public void excluirAmizade(int idAmizade, int idUsuarioLogado) {
        amizadeApplication.excluirAmizade(idAmizade, idUsuarioLogado);
    }

    public void aceitarAmizade(int idAmizade, int idUsuarioLogado) {
        amizadeApplication.aceitarAmizade(idAmizade, idUsuarioLogado);
    }

    public List<FriendDTO> listarAmigos(int idUsuarioLogado) {
        return amizadeApplication.listarAmigos(idUsuarioLogado);
    }

    public List<PendingRequestDTO> listarConvitesPendentes(int idUsuarioLogado) {
        return amizadeApplication.listarConvitesPendentes(idUsuarioLogado);
    }
}