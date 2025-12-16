package com.doback.E_rank.infrastructure.notificacao;

import com.doback.E_rank.interfaces.Notificacao;
import com.doback.E_rank.interfaces.NotificacaoFactory;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoFactoryImpl implements NotificacaoFactory {

    @Override
    public Notificacao criarNotificacao(String tipo) {
        switch (tipo.toLowerCase()) {
            case "email":
                return new NotificacaoEmail();
            case "push":
                return new NotificacaoPush();
            case "sistema":
                return new NotificacaoSistema();
            default:
                throw new IllegalArgumentException("Tipo de notificação inválido: " + tipo);
        }
    }
}