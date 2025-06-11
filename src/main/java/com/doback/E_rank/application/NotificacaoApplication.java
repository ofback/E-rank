package com.doback.E_rank.application;

import com.doback.E_rank.interfaces.Notificacao;
import com.doback.E_rank.interfaces.NotificacaoFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoApplication {

    private final NotificacaoFactory notificacaoFactory;

    // Recebemos a FÁBRICA via injeção de dependência
    public NotificacaoApplication(NotificacaoFactory notificacaoFactory) {
        this.notificacaoFactory = notificacaoFactory;
    }

    public void enviarNotificacao(String tipo, String mensagem, String destinatario) {
        // 1. Usamos a fábrica para criar o objeto de notificação
        Notificacao notificacao = notificacaoFactory.criarNotificacao(tipo);

        // 2. Usamos o objeto criado
        notificacao.enviar(mensagem, destinatario);
    }
}