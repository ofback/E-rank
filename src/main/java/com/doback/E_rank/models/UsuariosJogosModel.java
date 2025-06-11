package com.doback.E_rank.models;

import jakarta.persistence.*;

@Entity
@Table(name = "usuariosJogos")
public class UsuariosJogosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_usuarios", referencedColumnName = "id", insertable = false, updatable = false)
    private UsuariosModel usuariosModel;

    @Column(name = "id_usuarios")
    private int idUsuarios;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_jogos", referencedColumnName = "id", insertable = false, updatable = false)
    private JogosModel jogosModel;

    @Column(name = "id_jogos")
    private int idJogos;

    public UsuariosJogosModel() {
    }

    public UsuariosJogosModel(UsuariosModel usuariosModel, JogosModel jogosModel) {
        this.usuariosModel = usuariosModel;
        this.jogosModel = jogosModel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public int getIdJogos() {
        return idJogos;
    }

    public void setIdJogos(int idJogos) {
        this.idJogos = idJogos;
    }
}
