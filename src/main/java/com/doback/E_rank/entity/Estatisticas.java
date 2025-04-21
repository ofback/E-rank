package com.doback.E_rank.entity;

public class Estatisticas {

    private int id;
    private int kills;
    private int assistencias;
    private int qtdPartidas;
    private int stsProvacao;
    private int vitorias;
    private int derrotas;
    private int recordKills;
    private int headshots;

    private int idUsuario;
    private int idJogo;
    private int idDesafio;

    public Estatisticas(int kills, int assistencias, int qtdPartidas, int stsProvacao, int vitorias, int derrotas, int recordKills, int headshots) {
        this.kills = kills;
        this.assistencias = assistencias;
        this.qtdPartidas = qtdPartidas;
        this.stsProvacao = stsProvacao;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.recordKills = recordKills;
        this.headshots = headshots;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getAssistencias() {
        return assistencias;
    }

    public void setAssistencias(int assistencias) {
        this.assistencias = assistencias;
    }

    public int getQtsPartidas() {
        return qtdPartidas;
    }

    public void setQtsPartidas(int qtsPartidas) {
        this.qtdPartidas = qtsPartidas;
    }

    public int getStsProvacao() {
        return stsProvacao;
    }

    public void setStsProvacao(int stsProvacao) {
        this.stsProvacao = stsProvacao;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getRecordKills() {
        return recordKills;
    }

    public void setRecordKills(int recordKills) {
        this.recordKills = recordKills;
    }

    public int getHeadshots() {
        return headshots;
    }

    public void setHeadshots(int headshots) {
        this.headshots = headshots;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public int getIdDesafio() {
        return idDesafio;
    }

    public void setIdDesafio(int idDesafio) {
        this.idDesafio = idDesafio;
    }

    public boolean validarEstatisticas() {
        return  kills >= 0 &&
                assistencias >= 0 &&
                qtdPartidas >= 0 &&
                stsProvacao >= 0 &&
                vitorias >= 0 &&
                derrotas >= 0 &&
                recordKills >= 0 &&
                headshots >= 0 &&
                (vitorias + derrotas <= qtdPartidas) &&
                (recordKills >= kills);
    }

    public String getErrosValidacao() {
        StringBuilder erros = new StringBuilder();

        if (kills < 0) erros.append("Kills não pode ser nulo ou negativo.\n");
        if (assistencias < 0) erros.append("Assistências não pode ser negativa.\n");
        if (qtdPartidas < 0) erros.append("Quantidade de partidas não pode ser negativa.\n");
        if (vitorias < 0) erros.append("Vitórias não pode ser negativa.\n");
        if (derrotas < 0) erros.append("Derrotas não pode ser negativa.\n");
        if (vitorias + derrotas > qtdPartidas) erros.append("Vitórias + Derrotas não pode ser maior que o total de partidas.\n");
        if (recordKills < kills) erros.append("Recorde de kills não pode ser menor que total de kills.\n");
        if (headshots < 0) erros.append("Headshots não pode ser negativo.\n");

        return erros.toString().trim();
    }

}
