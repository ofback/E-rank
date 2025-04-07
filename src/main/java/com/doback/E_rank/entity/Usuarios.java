package com.doback.E_rank.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "sts")
    private char sts;

    @Column(name = "biografia")
    private String biografia;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "data_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Column(name = "nome")
    private String nome;

    @ManyToMany
    @JoinTable(
            name = "usuarios_jogos",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_jogo")
    )
    private List<Jogos> jogos;

    @OneToMany(mappedBy = "usuario1", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Amizades> amizades = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<FeedMensagens> feedMensagens = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<RegistroTimes> registroTimes = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Estatisticas> estatisticas = new ArrayList<>();

    @OneToMany(mappedBy = "usuarios", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<VotacaoEstatisticas> votacaoEstatisticas = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Times> times = new ArrayList<>();

    public Usuarios(char sts, String biografia, String nickname, String email, String senha, Date dataCriacao, String nome) {
        this.sts = sts;
        this.biografia = biografia;
        this.nickname = nickname;
        this.email = email;
        this.senha = senha;
        this.dataCriacao = dataCriacao;
        this.nome = nome;
    }

    public Usuarios() {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public List<Jogos> getJogos() {
//        return jogos;
//    }
//
//    public void setJogos(List<Jogos> jogos) {
//        this.jogos = jogos;
//    }
//
//    public List<Amizades> getAmizades() {
//        return amizades;
//    }
//
//    public void setAmizades(List<Amizades> amizades) {
//        this.amizades = amizades;
//    }
//
//    public List<FeedMensagens> getFeedMensagens() {
//        return feedMensagens;
//    }
//
//    public void setFeedMensagens(List<FeedMensagens> feedMensagens) {
//        this.feedMensagens = feedMensagens;
//    }
//
//    public List<RegistroTimes> getRegistroTimes() {
//        return registroTimes;
//    }
//
//    public void setRegistroTimes(List<RegistroTimes> registroTimes) {
//        this.registroTimes = registroTimes;
//    }
//
//    public List<Estatisticas> getEstatisticas() {
//        return estatisticas;
//    }
//
//    public void setEstatisticas(List<Estatisticas> estatisticas) {
//        this.estatisticas = estatisticas;
//    }
//
//    public List<VotacaoEstatisticas> getVotacaoEstatisticas() {
//        return votacaoEstatisticas;
//    }
//
//    public void setVotacaoEstatisticas(List<VotacaoEstatisticas> votacaoEstatisticas) {
//        this.votacaoEstatisticas = votacaoEstatisticas;
//    }
//
//    public List<Times> getTimes() {
//        return times;
//    }
//
//    public void setTimes(List<Times> times) {
//        this.times = times;
//    }
}
