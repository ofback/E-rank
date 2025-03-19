package com.doback.E_rank.entity;

public class Estatistica {
    private Long idEstatistica;
    private Long kill;
    private int assistencia;
    private int qtd_partida;
    private int sts_provacao;

    public Estatistica(Long idEstatistica, Long kill, int assistencia, int qtd_partida, int sts_provacao) {
        this.idEstatistica = idEstatistica;
        this.kill = kill;
        this.assistencia = assistencia;
        this.qtd_partida = qtd_partida;
        this.sts_provacao = sts_provacao;
    }

    public Long getIdEstatistica() {
        return idEstatistica;
    }

    public void setIdEstatistica(Long idEstatistica) {
        this.idEstatistica = idEstatistica;
    }

    public Long getKill() {
        return kill;
    }

    public void setKill(Long kill) {
        this.kill = kill;
    }

    public int getAssistencia() {
        return assistencia;
    }

    public void setAssistencia(int assistencia) {
        this.assistencia = assistencia;
    }

    public int getQtd_partida() {
        return qtd_partida;
    }

    public void setQtd_partida(int qtd_partida) {
        this.qtd_partida = qtd_partida;
    }

    public int getSts_provacao() {
        return sts_provacao;
    }

    public void setSts_provacao(int sts_provacao) {
        this.sts_provacao = sts_provacao;
    }
}