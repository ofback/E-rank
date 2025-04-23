package com.doback.E_rank.entity;

public class Amizades {

    private int id;

    private char status;

    private String dataSolicitacao;

    private int idUsuario1;

    private int idUsuario2;

    public Amizades() {

    }
    public Amizades(int idUsuario1, int idUsuario2, char status, String dataSolicitacao) {
        this.idUsuario1 = idUsuario1;
        this.idUsuario2 = idUsuario2;
        this.status = status;
        this.dataSolicitacao = dataSolicitacao;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public String getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(String dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario1() {
        return idUsuario1;
    }

    public void setIdUsuario1(int idUsuario1) {
        this.idUsuario1 = idUsuario1;
    }

    public int getIdUsuario2() {
        return idUsuario2;
    }

    public void setIdUsuario2(int idUsuario2) {
        this.idUsuario2 = idUsuario2;
    }

    public boolean validarAmizades() {
        return  idUsuario1 > 0 &&
                idUsuario2 > 0 &&
                idUsuario1 != idUsuario2 &&
                (status == 'A' || status == 'I') &&
                && dataSolicitacao != null && !dataSolicitacao.trim().isEmpty();
    }

    public String getErrosValidacao() {
        StringBuilder erros = new StringBuilder();

        if (idUsuario1 <= 0) {
            erros.append("ID do solicitante deve ser maior que zero. ");
        }

        if (idUsuario2 <= 0) {
            erros.append("ID do receptor deve ser maior que zero. ");
        }

        if (idUsuario1 == idUsuario2) {
            erros.append("Solicitante e receptor não podem ser o mesmo usuário. ");
        }

        if (status != 'A' && status != 'I') {
            erros.append("Status deve ser 'A' (ativo) ou 'I' (inativo). ");
        }
        if (dataSolicitacao == null){
            erros.append("Data de envio é obrigatória. ");
        }

        return erros.toString().trim();
    }
}
