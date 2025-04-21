package com.doback.E_rank.entity;

import java.util.Date;

public class FeedMensagens {

    private String atividade;
    private String descricao;
    private String mensagem;
    private char status;
    private Date dataEnvio;
    private int idUsuario;

    public FeedMensagens() {}

    public FeedMensagens(String atividade, String descricao, String mensagem, char status, Date dataEnvio, int idUsuario) {
        this.atividade = atividade;
        this.descricao = descricao;
        this.mensagem = mensagem;
        this.status = status;
        this.dataEnvio = dataEnvio;
        this.idUsuario = idUsuario;
    }

    public boolean validarMensagem() {
        return atividade != null && !atividade.trim().isEmpty()
                && descricao != null && descricao.length() >= 10
                && mensagem != null && !mensagem.trim().isEmpty()
                && (status == 'A' || status == 'I')
                && dataEnvio != null && !dataEnvio.after(new Date())
                && idUsuario > 0;
    }

    public String getErrosValidacao() {
        StringBuilder erros = new StringBuilder();

        if (atividade == null || atividade.trim().isEmpty()) erros.append("Atividade não pode ser vazia. ");
        if (descricao == null || descricao.length() < 10) erros.append("Descrição deve ter pelo menos 10 caracteres. ");
        if (mensagem == null || mensagem.trim().isEmpty()) erros.append("Mensagem não pode ser vazia. ");
        if (status != 'A' && status != 'I') erros.append("Status deve ser 'A' (ativo) ou 'I' (inativo). ");
        if (dataEnvio == null) erros.append("Data de envio é obrigatória. ");
        else if (dataEnvio.after(new Date())) erros.append("Data de envio não pode estar no futuro. ");
        if (idUsuario <= 0) erros.append("Id do usuário deve ser maior que zero. ");

        return erros.toString().trim();
    }



    public String getAtividade() { return atividade; }
    public void setAtividade(String atividade) { this.atividade = atividade; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }

    public char getStatus() { return status; }
    public void setStatus(char status) { this.status = status; }

    public Date getDataEnvio() { return dataEnvio; }
    public void setDataEnvio(Date dataEnvio) { this.dataEnvio = dataEnvio; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
}
