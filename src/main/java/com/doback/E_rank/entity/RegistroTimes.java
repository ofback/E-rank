package com.doback.E_rank.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "registroTimes")
public class RegistroTimes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "data_entrada")
    private Date data_entrada;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_times", referencedColumnName = "id", insertable = false, updatable = false)
    private Times times;

    @Column(name = "id_times")
    private int idTimes;


    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_usuarios", referencedColumnName = "id", insertable = false, updatable = false)
    private Usuarios usuario;

    @Column(name = "id_usuarios")
    private int idUsuarios;

    public RegistroTimes() {
    }

    public RegistroTimes(String cargo, Date data_entrada, Times time, Usuarios usuario) {
        this.cargo = cargo;
        this.data_entrada = data_entrada;
        this.times = time;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void add(RegistroTimes registroTimes) {
    }

    public int getIdTimes() {
        return idTimes;
    }

    public void setIdTimes(int idTimes) {
        this.idTimes = idTimes;
    }

    public int getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }
}
