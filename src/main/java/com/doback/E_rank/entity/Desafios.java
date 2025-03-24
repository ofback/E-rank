package com.doback.E_rank.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name ="desafios")

public class Desafios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idDesafio")
    private Long id_desafio;
    @Column(name = "data_desafio")
    private Date data_desafio;
    @Column(name = "resultado")
    private String resultado;
    @Column(name = "sts")
    private char sts;

    public Desafios(Long id_desafio, Date data_desafio, String resultado, char sts) {
        this.id_desafio = id_desafio;
        this.data_desafio = data_desafio;
        this.resultado = resultado;
        this.sts = sts;
    }

    public Desafios() {

    }

    public Long getId_desafio() {
        return id_desafio;
    }

    public void setId_desafio(Long id_desafio) {
        this.id_desafio = id_desafio;
    }

    public Date getData_desafio() {
        return data_desafio;
    }

    public void setData_desafio(Date data_desafio) {
        this.data_desafio = data_desafio;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public char getSts() {
        return sts;
    }

    public void setSts(char sts) {
        this.sts = sts;
    }
}
