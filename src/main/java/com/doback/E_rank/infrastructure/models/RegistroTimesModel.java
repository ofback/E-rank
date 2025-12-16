package com.doback.E_rank.infrastructure.models;

import jakarta.persistence.*;

@Entity
@Table(name = "registro_time")
public class RegistroTimesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro_time")
    private int id;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "status")
    private String status;

    @Column(name = "data_entrada")
    private String data_entrada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Times_id_time", referencedColumnName = "id", insertable = false, updatable = false)
    private TimesModel timesModel;

    @Column(name = "Times_id_time")
    private int idTimes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Usuarios_id_usuario", referencedColumnName = "id", insertable = false, updatable = false)
    private UsuariosModel usuariosModel;

    @Column(name = "Usuarios_id_usuario")
    private int idUsuarios;

    public RegistroTimesModel() {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(String data_entrada) {
        this.data_entrada = data_entrada;
    }

    public TimesModel getTimesModel() {
        return timesModel;
    }

    public void setTimesModel(TimesModel timesModel) {
        this.timesModel = timesModel;
    }

    public int getIdTimes() {
        return idTimes;
    }

    public void setIdTimes(int idTimes) {
        this.idTimes = idTimes;
    }

    public UsuariosModel getUsuariosModel() {
        return usuariosModel;
    }

    public void setUsuariosModel(UsuariosModel usuariosModel) {
        this.usuariosModel = usuariosModel;
    }

    public int getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }
}

