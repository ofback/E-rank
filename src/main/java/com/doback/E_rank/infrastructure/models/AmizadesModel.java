// E-rank/src/main/java/com/doback/E_rank/infrastructure/models/AmizadesModel.java
package com.doback.E_rank.infrastructure.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "amizades")
public class AmizadesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "sts")
    private char status;

    @Column(name = "data_solicitacao")
    private String dataSolicitacao;

    // --- CORREÇÃO: Agora funciona pois DesafiosModel tem o campo 'amizadesModel' ---
    @OneToMany(mappedBy = "amizadesModel", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<DesafiosModel> desafiosModels = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario1", referencedColumnName = "id", insertable = false, updatable = false)
    private UsuariosModel usuariosModel1;

    @Column(name = "id_usuario1")
    private int idUsuario1;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario2", referencedColumnName = "id", insertable = false, updatable = false)
    private UsuariosModel usuariosModel2;

    @Column(name = "id_usuario2")
    private int idUsuario2;

    public AmizadesModel() {}

    // Getters e Setters (inclua para a nova lista se necessário, mas o Lombok ou manual abaixo resolve)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public char getStatus() { return status; }
    public void setStatus(char status) { this.status = status; }
    public String getDataSolicitacao() { return dataSolicitacao; }
    public void setDataSolicitacao(String dataSolicitacao) { this.dataSolicitacao = dataSolicitacao; }
    public int getIdUsuario1() { return idUsuario1; }
    public void setIdUsuario1(int idUsuario1) { this.idUsuario1 = idUsuario1; }
    public int getIdUsuario2() { return idUsuario2; }
    public void setIdUsuario2(int idUsuario2) { this.idUsuario2 = idUsuario2; }
    public List<DesafiosModel> getDesafiosModels() { return desafiosModels; }
    public void setDesafiosModels(List<DesafiosModel> desafiosModels) { this.desafiosModels = desafiosModels; }
}