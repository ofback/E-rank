package com.doback.E_rank.entity;

public class Temporada {
    private Long IdTemporada;
    private Long IdUsuario1;
    private Long IdUsuario2;
    private Long Status;


    public Temporada(Long idTemporada, Long idUsuario1, Long idUsuario2, Long status) {
        IdTemporada=IdTemporada;
        IdUsuario1 = idUsuario1;
        IdUsuario2 = idUsuario2;
        Status = status;
    }

    public static Temporada stream() {
        return null;
    }

    public static void removeIf(Object o) {
    }

    public Long getIdTemporada() {
        return IdTemporada;
    }

    public void setIdTemporada(Long idTemporada) {

    }

    private Long IdTemporada() {
        return 0L;
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

    public void add(Temporada temporada) {
    }
}
