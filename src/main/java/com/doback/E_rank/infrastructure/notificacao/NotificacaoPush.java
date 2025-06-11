package com.doback.E_rank.infrastructure.notificacao;

import com.doback.E_rank.interfaces.Notificacao;
import org.springframework.stereotype.Component;

@Component("push") // <- Nome do Bean
public class NotificacaoPush implements Notificacao {
    @Override
    public void enviar(String mensagem, String destinatario) {
        // Lógica para enviar para APN, Firebase, etc.
        System.out.println("Enviando Push Notification para " + destinatario + ": " + mensagem);
    }
}