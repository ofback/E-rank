package com.doback.E_rank.interfaces;

// Esta é a abstração da nossa fábrica
public interface NotificacaoFactory {
    Notificacao criarNotificacao(String tipo);
}