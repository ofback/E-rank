package com.doback.E_rank.entity;

import java.time.LocalDate;

public class Amizades {

    private int id;
    private int idSolicitante;
    private int idReceptor;
    private String status; // pendente, aceita, recusada
    private LocalDate dataCriacao;

    public Amizades() {}

    public Amizades(int idSolicitante, int idReceptor, String status, LocalDate dataCriacao) {
        this.idSolicitante = idSolicitante;
        this.idReceptor = idReceptor;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(int idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    public int getIdReceptor() {
        return idReceptor;
    }

    public void setIdReceptor(int idReceptor) {
        this.idReceptor = idReceptor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }


    public boolean validarAmizade() {
        return idSolicitante > 0 &&
                idReceptor > 0 &&
                idSolicitante != idReceptor &&
                status != null &&
                (status.equalsIgnoreCase("pendente") ||
                        status.equalsIgnoreCase("aceita") ||
                        status.equalsIgnoreCase("recusada"));
    }

    public String getErrosValidacao() {
        StringBuilder erros = new StringBuilder();

        if (idSolicitante <= 0) {
            erros.append("ID do solicitante deve ser maior que zero.\n");
        }

        if (idReceptor <= 0) {
            erros.append("ID do receptor deve ser maior que zero.\n");
        }

        if (idSolicitante == idReceptor) {
            erros.append("Solicitante e receptor não podem ser o mesmo usuário.\n");
        }

        if (status == null ||
                !(status.equalsIgnoreCase("pendente") || status.equalsIgnoreCase("aceita") || status.equalsIgnoreCase("recusada"))) {
            erros.append("Status deve ser 'pendente', 'aceita' ou 'recusada'.\n");
        }

        return erros.toString().trim();
    }
}
