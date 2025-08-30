package com.doback.E_rank.dto;

public class PlayerCardDTO {
    private String nickname;
    private String nome;
    private int overallRating;
    private String estiloDeJogo; // Ex: "Executor", "Aim God", "Garçom"
    private long vitorias;
    private long derrotas;
    private long kills;
    private long assistencias;
    private long headshots;
    private double kdRatio;
    private long partidasJogadas;

    public PlayerCardDTO(String nickname, String nome) {
        this.nickname = nickname;
        this.nome = nome;
    }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getOverallRating() { return overallRating; }
    public void setOverallRating(int overallRating) { this.overallRating = overallRating; }
    public String getEstiloDeJogo() { return estiloDeJogo; }
    public void setEstiloDeJogo(String estiloDeJogo) { this.estiloDeJogo = estiloDeJogo; }
    public long getVitorias() { return vitorias; }
    public void setVitorias(long vitorias) { this.vitorias = vitorias; }
    public long getDerrotas() { return derrotas; }
    public void setDerrotas(long derrotas) { this.derrotas = derrotas; }
    public long getKills() { return kills; }
    public void setKills(long kills) { this.kills = kills; }
    public long getAssistencias() { return assistencias; }
    public void setAssistencias(long assistencias) { this.assistencias = assistencias; }
    public long getHeadshots() { return headshots; }
    public void setHeadshots(long headshots) { this.headshots = headshots; }
    public double getKdRatio() { return kdRatio; }
    public void setKdRatio(double kdRatio) { this.kdRatio = kdRatio; }
    public long getPartidasJogadas() { return partidasJogadas; }
    public void setPartidasJogadas(long partidasJogadas) { this.partidasJogadas = partidasJogadas; }
}

