package com.doback.E_rank.application;
import com.doback.E_rank.entity.Amizades;
import com.doback.E_rank.infrastructure.models.AmizadesModel;
import com.doback.E_rank.interfaces.AmizadesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import com.doback.E_rank.application.NotificacaoApplication;

@Service
public class AmizadesApplication {

    private final AmizadesRepository amizadeRepository;
    private final NotificacaoApplication notificacaoApplication;


    public AmizadesApplication(AmizadesRepository amizadeRepository, NotificacaoApplication notificacaoApplication) {
        this.amizadeRepository = amizadeRepository;
        this.notificacaoApplication = notificacaoApplication;
    }

    public List<AmizadesModel> obterTodasAmizades() {
        return amizadeRepository.buscar();
    }

    public AmizadesModel obterAmizadePorId(int id) {
        return amizadeRepository.searchByCode(id);
    }

    public void criarAmizade(AmizadesModel amizadesModel) {
        validar(amizadesModel);

        amizadeRepository.addAmizades(amizadesModel);

        String mensagem = "Você recebeu um novo pedido de amizade do usuário " + amizadesModel.getIdUsuario1();
        String destinatario = "usuario_id:" + amizadesModel.getIdUsuario2(); // Exemplo de identificador
        notificacaoApplication.enviarNotificacao("sistema", mensagem, destinatario);
    }

    public void excluirAmizade(int id) {
        amizadeRepository.removeAmizades(id);
        // Adicionar uma notificação de amizade removida
    }

    public void atualizarAmizades(int id, AmizadesModel amizadesModel) {
        validar(amizadesModel);
        amizadeRepository.updateAmizades(id, amizadesModel);
        // Poderia notificar sobre a amizade ter sido aceita, por exemplo
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
}