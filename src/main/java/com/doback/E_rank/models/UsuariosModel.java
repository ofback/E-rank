package com.doback.E_rank.models;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "usuarios")
public class UsuariosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "data_nascimento")
    private String dataNascimento;

    @Column(name = "email")
    private String email;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "senha")
    private String senha;

    @Column(name = "biografia")
    private String biografia;

    @Column(name = "sts")
    private char sts;

    @Column(name = "data_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @OneToMany(mappedBy = "usuariosModel", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<UsuariosJogosModel> usuariosJogoModels = new ArrayList<>();

    @OneToMany(mappedBy = "usuariosModel1", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<AmizadesModel> amizadesModel1 = new ArrayList<>();

    @OneToMany(mappedBy = "usuariosModel2", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<AmizadesModel> amizadesModel2 = new ArrayList<>();

    @OneToMany(mappedBy = "usuariosModel", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<FeedMensagensModel> feedMensagenModels = new ArrayList<>();

    @OneToMany(mappedBy = "usuariosModel", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<RegistroTimesModel> registroTimeModels = new ArrayList<>();

    @OneToMany(mappedBy = "usuariosModel", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<EstatisticasModel> estatisticasModels = new ArrayList<>();

    @OneToMany(mappedBy = "usuariosModel", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<VotacaoEstatisticasModel> votacaoEstatisticaModels = new ArrayList<>();

    @OneToMany(mappedBy = "usuariosModel", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<TimesModel> timesModels = new ArrayList<>();

    public UsuariosModel(String nome, String cpf, String dataNascimento, String email, String nickname, String senha, String biografia, char sts, Date dataCriacao) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.nickname = nickname;
        this.senha = senha;
        this.biografia = biografia;
        this.sts = sts;
        this.dataCriacao = dataCriacao;
    }

    public UsuariosModel() {
    }


    public char getSts() {
        return sts;
    }

    public void setSts(char sts) {
        this.sts = sts;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public List<JogosModel> getJogos() {
//        return jogos;
//    }
//
//    public void setJogos(List<JogosModel> jogos) {
//        this.jogos = jogos;
//    }
//
//    public List<AmizadesModel> getAmizades() {
//        return amizades;
//    }
//
//    public void setAmizades(List<AmizadesModel> amizades) {
//        this.amizades = amizades;
//    }
//
//    public List<FeedMensagensModel> getFeedMensagens() {
//        return feedMensagenModels;
//    }
//
//    public void setFeedMensagens(List<FeedMensagensModel> feedMensagenModels) {
//        this.feedMensagenModels = feedMensagenModels;
//    }
//
//    public List<RegistroTimesModel> getRegistroTimes() {
//        return registroTimeModels;
//    }
//
//    public void setRegistroTimes(List<RegistroTimesModel> registroTimeModels) {
//        this.registroTimeModels = registroTimeModels;
//    }
//
//    public List<EstatisticasModel> getEstatisticas() {
//        return estatisticas;
//    }
//
//    public void setEstatisticas(List<EstatisticasModel> estatisticas) {
//        this.estatisticas = estatisticas;
//    }
//
//    public List<VotacaoEstatisticasModel> getVotacaoEstatisticas() {
//        return votacaoEstatisticaModels;
//    }
//
//    public void setVotacaoEstatisticas(List<VotacaoEstatisticasModel> votacaoEstatisticaModels) {
//        this.votacaoEstatisticaModels = votacaoEstatisticaModels;
//    }
//
//    public List<TimesModel> getTimes() {
//        return times;
//    }
//
//    public void setTimes(List<TimesModel> times) {
//        this.times = times;
//    }
}
