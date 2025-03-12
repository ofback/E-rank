package com.doback.E_rank.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MembroDoTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMembro;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_time")
    private Time time;

    private String cargo;
    private LocalDateTime dataEntrada;


    public Long getIdMembro() {
        return idMembro;
    }

    public void setIdMembro(Long idMembro) {
        this.idMembro = idMembro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
}
