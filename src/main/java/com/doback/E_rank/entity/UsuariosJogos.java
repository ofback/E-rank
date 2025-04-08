package com.doback.E_rank.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "usuariosJogos")
public class UsuariosJogos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_usuarios", referencedColumnName = "id", insertable = false, updatable = false)
    private Usuarios usuarios;

    @Column(name = "id_usuarios")
    private int idUsuarios;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_jogos", referencedColumnName = "id", insertable = false, updatable = false)
    private Jogos jogos;

    @Column(name = "id_jogos")
    private int idJogos;

    public UsuariosJogos() {
    }

    public UsuariosJogos(Usuarios usuarios, Jogos jogos) {
        this.usuarios = usuarios;
        this.jogos = jogos;
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
