package com.doback.E_rank.entity;

public class Amizade {
    private Long IdAmizade;
    private Long IdUsuario1;
    private Long IdUsuario2;
    private Long Status;

    public Amizade(Long idAmizade, Long idUsuario1, Long idUsuario2, Long status) {
        IdAmizade = idAmizade;
        IdUsuario1 = idUsuario1;
        IdUsuario2 = idUsuario2;
        Status = status;
    }

    public Long getIdAmizade() {
        return IdAmizade;
    }

    public void setIdAmizade(Long idAmizade) {
        IdAmizade = idAmizade;
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
