package com.doback.E_rank.infrastructure.notificacao;

import com.doback.E_rank.interfaces.Notificacao;
import org.springframework.stereotype.Component;

@Component("email")
public class NotificacaoEmail implements Notificacao {
    @Override
    public void enviar(String mensagem, String destinatario) {
        System.out.println("Enviando E-mail para " + destinatario + ": " + mensagem);
    }
}