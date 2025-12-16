package com.doback.E_rank.application;

import com.doback.E_rank.interfaces.Notificacao;
import com.doback.E_rank.interfaces.NotificacaoFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoApplication {

    private final NotificacaoFactory notificacaoFactory;

    public NotificacaoApplication(NotificacaoFactory notificacaoFactory) {
        this.notificacaoFactory = notificacaoFactory;
    }

    public void enviarNotificacao(String tipo, String mensagem, String destinatario) {
        Notificacao notificacao = notificacaoFactory.criarNotificacao(tipo);

        notificacao.enviar(mensagem, destinatario);
    }
}