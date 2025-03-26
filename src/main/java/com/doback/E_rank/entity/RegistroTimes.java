package com.doback.E_rank.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "registroTimes")
public class RegistroTimes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro_times")
    private Long id_registro_times;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "data_entrada")
    private Date data_entrada;

    @ManyToOne
    @JoinColumn(name = "id_time", referencedColumnName = "id_time")
    private Times time;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuarios usuario;

    public RegistroTimes(Long id_registro_times, String cargo, Date data_entrada, Times time, Usuarios usuario) {
        this.id_registro_times = id_registro_times;
        this.cargo = cargo;
        this.data_entrada = data_entrada;
        this.time = time;
        this.usuario = usuario;
    }

    public RegistroTimes() {
    }

    public Long getId_registro_times() {
        return id_registro_times;
    }

    public void setId_registro_times(Long id_registro_times) {
        this.id_registro_times = id_registro_times;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public Times getTime() {
        return time;
    }

    public void setTime(Times time) {
        this.time = time;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public void add(RegistroTimes registroTimes) {
    }
}
