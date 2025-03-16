package com.doback.E_rank.entity;

public class Times {
    private Long IdTimes;
    private Long IdUsuario1;
    private Long IdUsuario2;
    private Long Status;

    public Times(Long idTimes, Long idUsuario1, Long idUsuario2, Long status) {
        IdTimes = idTimes;
        IdUsuario1 = idUsuario1;
        IdUsuario2 = idUsuario2;
        Status = status;
    }

    public Long getIdTimes() {
        return IdTimes;
    }

    public void setIdAmizade(Long idAmizade) {
        IdTimes = idAmizade;
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
