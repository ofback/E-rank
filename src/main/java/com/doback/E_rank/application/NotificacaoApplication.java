package com.doback.E_rank.application;

import com.doback.E_rank.interfaces.Notificacao;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class NotificacaoApplication {

    private final Map<String, Notificacao> notificacaoStrategies;

    // O Spring vai injetar automaticamente um Mapa com todos os beans do tipo "Notificacao".
    // A chave do mapa será o nome do bean que definimos ("email", "push", "sistema").
    // O valor será a instância do próprio bean.
    public NotificacaoApplication(Map<String, Notificacao> notificacaoStrategies) {
        this.notificacaoStrategies = notificacaoStrategies;
    }

    public void enviarNotificacao(String tipo, String mensagem, String destinatario) {
        Notificacao notificacao = notificacaoStrategies.get(tipo.toLowerCase());

        if (notificacao == null) {
            throw new IllegalArgumentException("Tipo de notificação desconhecido ou não implementado: " + tipo);
        }

        notificacao.enviar(mensagem, destinatario);
    }
}