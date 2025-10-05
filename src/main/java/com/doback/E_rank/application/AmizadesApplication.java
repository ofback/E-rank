package com.doback.E_rank.application;

import com.doback.E_rank.entity.Amizades;
import com.doback.E_rank.infrastructure.models.AmizadesModel;
import com.doback.E_rank.infrastructure.repository.jpa.AmizadesJpa;
import com.doback.E_rank.interfaces.AmizadesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmizadesApplication {

    private final AmizadesRepository amizadeRepository;
    private final NotificacaoApplication notificacaoApplication;
    private final AmizadesJpa amizadesJpa;


    public AmizadesApplication(AmizadesRepository amizadeRepository,
                               NotificacaoApplication notificacaoApplication,
                               AmizadesJpa amizadesJpa) {
        this.amizadeRepository = amizadeRepository;
        this.notificacaoApplication = notificacaoApplication;
        this.amizadesJpa = amizadesJpa;
    }

    public List<AmizadesModel> obterTodasAmizades() {
        return amizadeRepository.buscar();
    }

    public AmizadesModel obterAmizadePorId(int id) {
        return amizadeRepository.searchByCode(id);
    }

    public void criarAmizade(int idRemetente, int idDestinatario) {
        AmizadesModel amizadesModel = new AmizadesModel();
        amizadesModel.setIdUsuario1(idRemetente);
        amizadesModel.setIdUsuario2(idDestinatario);
        amizadesModel.setStatus('P'); // 'P' de Pendente
        amizadesModel.setDataSolicitacao(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()));

        validar(amizadesModel);
        amizadeRepository.addAmizades(amizadesModel);

        String mensagem = "Você recebeu um novo pedido de amizade.";
        String destinatario = "usuario_id:" + idDestinatario;
        notificacaoApplication.enviarNotificacao("sistema", mensagem, destinatario);
    }

    public void excluirAmizade(int id) {
        amizadeRepository.removeAmizades(id);
    }

    public void atualizarAmizades(int id, AmizadesModel amizadesModel) {
        validar(amizadesModel);
        amizadeRepository.updateAmizades(id, amizadesModel);
    }

    private Amizades validar(AmizadesModel amizadesModel){
        Amizades amizades = new Amizades(
                amizadesModel.getIdUsuario1(),
                amizadesModel.getIdUsuario2(),
                amizadesModel.getStatus(),
                amizadesModel.getDataSolicitacao()
        );

        if(!amizades.validarAmizades()){
            throw new IllegalArgumentException("Validação da amizade falhou: " + amizades.getErrosValidacao());
        }
        return amizades;
    }

    public List<AmizadesModel> listarAmigos(int idUsuarioLogado) {
        return amizadesJpa.findByIdUsuario1AndStatusOrIdUsuario2AndStatus(idUsuarioLogado, 'A', idUsuarioLogado, 'A');
    }

    public List<AmizadesModel> listarConvitesPendentes(int idUsuarioLogado) {
        return amizadesJpa.findByIdUsuario2AndStatus(idUsuarioLogado, 'P');
    }
}
