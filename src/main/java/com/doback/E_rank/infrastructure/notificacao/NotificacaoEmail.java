package com.doback.E_rank.infrastructure.notificacao;

import com.doback.E_rank.interfaces.Notificacao;
import org.springframework.stereotype.Component;

@Component("email") // <- Nome do Bean
public class NotificacaoEmail implements Notificacao {
    @Override
    public void enviar(String mensagem, String destinatario) {
        // Aqui entraria a lógica real de envio de e-mail (usando JavaMailSender, etc.)
        System.out.println("Enviando E-mail para " + destinatario + ": " + mensagem);
    }
}