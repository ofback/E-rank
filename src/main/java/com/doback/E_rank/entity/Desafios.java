// E-rank/src/main/java/com/doback/E_rank/entity/Desafios.java
package com.doback.E_rank.entity;

import java.time.LocalDateTime;

public class Desafios {
    private int id;
    private int desafianteId;
    private int desafiadoId;
    private String status;
    private LocalDateTime dataHora;

    public Desafios() {}

    public Desafios(int desafianteId, int desafiadoId, String status, LocalDateTime dataHora) {
        this.desafianteId = desafianteId;
        this.desafiadoId = desafiadoId;
        this.status = status;
        this.dataHora = dataHora;
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getDesafianteId() { return desafianteId; }
    public void setDesafianteId(int desafianteId) { this.desafianteId = desafianteId; }
    public int getDesafiadoId() { return desafiadoId; }
    public void setDesafiadoId(int desafiadoId) { this.desafiadoId = desafiadoId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
}