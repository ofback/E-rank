package com.doback.E_rank.dto;

public class RankingDTO {
    private int posicao;
    private String nickname;
    private Long pontuacao;
    private Long vitorias;
    private Long kills;


    public RankingDTO(int posicao, String nickname, Long pontuacao, Long vitorias, Long kills) {
        this.posicao = posicao;
        this.nickname = nickname;
        this.pontuacao = pontuacao;
        this.vitorias = vitorias;
        this.kills = kills;
    }


    public RankingDTO(String nickname, Long pontuacao, Long vitorias, Long kills) {
        this.nickname = nickname;
        this.pontuacao = pontuacao != null ? pontuacao : 0L;
        this.vitorias = vitorias != null ? vitorias : 0L;
        this.kills = kills != null ? kills : 0L;
        this.posicao = 0;
    }

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

    public Long getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Long pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Long getVitorias() {
        return vitorias;
    }

    public void setVitorias(Long vitorias) {
        this.vitorias = vitorias;
    }

    public Long getKills() {
        return kills;
    }

    public void setKills(Long kills) {
        this.kills = kills;
    }
}