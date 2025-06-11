package com.doback.E_rank.models;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "papeis")
public class PapelModel implements GrantedAuthority{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String nome; // Ex: ROLE_USUARIO, ROLE_ADMIN

    @Override
    public String getAuthority() {
        return this.nome;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

