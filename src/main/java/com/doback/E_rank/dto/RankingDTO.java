package com.doback.E_rank.dto;

public class RankingDTO {
    private int posicao;
    private String nickname;
    private int pontuacao;
    private int vitorias;
    private int kills;

    public RankingDTO(int posicao, String nickname, int pontuacao, int vitorias, int kills) {
        this.posicao = posicao;
        this.nickname = nickname;
        this.pontuacao = pontuacao;
        this.vitorias = vitorias;
        this.kills = kills;
    }

    // Getters e Setters
    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }
}
