package com.doback.E_rank.entity;

public class Desafio {
    private Long IdDesafio;
    private Long IdUsuario1;
    private Long IdUsuario2;
    private Long Status;

    public Desafio(Long idDesafio, Long idUsuario1, Long idUsuario2, Long status) {
        IdDesafio = idDesafio;
        IdUsuario1 = idUsuario1;
        IdUsuario2 = idUsuario2;
        Status = status;
    }

    public Long getIdDesafio() {
        return IdDesafio;
    }

    public void setIdDesafio(Long idDesafio) {
        IdDesafio = idDesafio;
    }

    public Long getIdUsuario1() {
        return IdUsuario1;
    }

    public void setIdUsuario1(Long idUsuario1) {
        IdUsuario1 = idUsuario1;
    }

    public Long getIdUsuario2() {
        return IdUsuario2;
    }

    public void setIdUsuario2(Long idUsuario2) {
        IdUsuario2 = idUsuario2;
    }

    public Long getStatus() {
        return Status;
    }

    public void setStatus(Long status) {
        Status = status;
    }
}
