package com.doback.E_rank.infrastructure.notificacao;

import com.doback.E_rank.interfaces.Notificacao;
import org.springframework.stereotype.Component;

@Component("sistema") // <- Nome do Bean
public class NotificacaoSistema implements Notificacao {
    @Override
    public void enviar(String mensagem, String destinatario) {
        // Lógica para salvar no banco de dados, talvez usando um repositório.
        System.out.println("Salvando notificação no sistema para " + destinatario + ": " + mensagem);
    }
}