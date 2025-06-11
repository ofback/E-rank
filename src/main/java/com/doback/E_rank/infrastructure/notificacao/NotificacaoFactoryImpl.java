package com.doback.E_rank.infrastructure.notificacao;

import com.doback.E_rank.interfaces.Notificacao;
import com.doback.E_rank.interfaces.NotificacaoFactory;
import org.springframework.stereotype.Component;

@Component // A fábrica é um bean gerenciado pelo Spring!
public class NotificacaoFactoryImpl implements NotificacaoFactory {

    @Override
    public Notificacao criarNotificacao(String tipo) {
        // A lógica de criação explícita que demonstra o padrão Factory Method
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