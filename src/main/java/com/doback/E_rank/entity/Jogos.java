package com.doback.E_rank.entity;


public class Jogos {

    private int id;
    private String nome;
    private String descricao;
    private String genero;

    public Jogos(String nome, String descricao, String genero) {
        this.nome = nome;
        this.descricao = descricao;
        this.genero = genero;

    }

    public Jogos() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean validarJogo() {
        return nome != null &&
                !nome.trim().isEmpty() &&
                nome.length() <= 100 &&
                descricao != null &&
                descricao.length() < 500 &&
                !descricao.trim().isEmpty() &&
                genero != null && !genero.trim().isEmpty();
    }

    public String getErrosValidacao() {
        StringBuilder errosValidacao = new StringBuilder();

        if (nome == null || nome.trim().isEmpty()) {
            errosValidacao.append("Nome do jogo não pode ser vazio.");
        }
        if (nome == null || nome.length() > 100) {
            errosValidacao.append("Nome do jogo não deve ter mais de 100 caracteres.");
        }

        if (descricao == null || descricao.trim().isEmpty()) {
            errosValidacao.append("Descrição do jogo não pode ser vazia.");
        }
        if (descricao == null || descricao.length() > 500) {
            errosValidacao.append("Descrição deve ter menos de 500 caracteres. ");
        }

        if (genero == null || genero.isEmpty()) {
            errosValidacao.append("Gênero do jogo não pode ser vazio.");
        }

        return errosValidacao.toString().trim();
    }

}
