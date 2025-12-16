package com.doback.E_rank.infrastructure.notificacao;

import com.doback.E_rank.interfaces.Notificacao;
import org.springframework.stereotype.Component;

@Component("sistema")
public class NotificacaoSistema implements Notificacao {
    @Override
    public void enviar(String mensagem, String destinatario) {
        System.out.println("Salvando notificação no sistema para " + destinatario + ": " + mensagem);
    }
}