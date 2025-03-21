package com.doback.E_rank.entity;

public class Usuarios {
    private Long IdUsuario;
    private Long IdUsuario1;
    private Long IdUsuario2;
    private Long Status;

    public Usuarios(Long idUsuario, Long idUsuario1, Long idUsuario2, Long status) {
        IdUsuario = idUsuario;
        IdUsuario1 = idUsuario1;
        IdUsuario2 = idUsuario2;
        Status = status;
    }

    public Long getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        IdUsuario = IdUsuario;
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
