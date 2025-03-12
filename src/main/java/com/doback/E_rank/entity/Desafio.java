package com.doback.E_rank.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Desafio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDesafio;

    @ManyToOne
    @JoinColumn(name = "id_usuario_desafiante", nullable = false)
    private Usuario usuarioDesafiante;

    @ManyToOne
    @JoinColumn(name = "id_usuario_desafiado", nullable = false)
    private Usuario usuarioDesafiado;

    @ManyToOne
    @JoinColumn(name = "id_jogo", nullable = false)
    private Jogo jogo;

    @Enumerated(EnumType.STRING)
    private StatusDesafio status;

    private String resultado; // Vencedor, perdedor (pode ser null até conclusão)

    private LocalDateTime dataCriacao;

    public Desafio() {
        this.dataCriacao = LocalDateTime.now();
        this.status = StatusDesafio.PENDENTE;
    }


    public Long getIdDesafio() {
        return idDesafio;
    }

    public void setIdDesafio(Long idDesafio) {
        this.idDesafio = idDesafio;
    }

    public Usuario getUsuarioDesafiante() {
        return usuarioDesafiante;
    }

    public void setUsuarioDesafiante(Usuario usuarioDesafiante) {
        this.usuarioDesafiante = usuarioDesafiante;
    }

    public Usuario getUsuarioDesafiado() {
        return usuarioDesafiado;
    }

    public void setUsuarioDesafiado(Usuario usuarioDesafiado) {
        this.usuarioDesafiado = usuarioDesafiado;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public StatusDesafio getStatus() {
        return status;
    }

    public void setStatus(StatusDesafio status) {
        this.status = status;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public enum StatusDesafio {
        PENDENTE, ACEITO, CONCLUIDO
    }
}
