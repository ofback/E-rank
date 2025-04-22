package com.doback.E_rank.entity;


import java.util.Date;

public class RegistroTimes {

    private int id;

    private String cargo;

    private String data_entrada;

    private int idTimes;

    private int idUsuarios;

    public RegistroTimes() {
    }

    public RegistroTimes(String cargo, String data_entrada, int idTimes, int idUsuarios) {
        this.cargo = cargo;
        this.data_entrada = data_entrada;
        this.idTimes = idTimes;
        this.idUsuarios = idUsuarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(String data_entrada) {
        this.data_entrada = data_entrada;
    }

    public int getIdTimes() {
        return idTimes;
    }

    public void setIdTimes(int idTimes) {
        this.idTimes = idTimes;
    }

    public int getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public boolean validarRegistroTimes() {
        return  cargo != null &&
                !cargo.trim().isEmpty() &&
                data_entrada != null && !data_entrada.trim().isEmpty() &&
                idTimes > 0 &&
                idUsuarios > 0;
    }
    public String getErrosValidacao() {
        StringBuilder errosValidacao = new StringBuilder();

        if (cargo == null || cargo.trim().isEmpty()) {
            errosValidacao.append("Cargo não pode ser vazio.\"");
        }
        if (data_entrada == null) {
            errosValidacao.append("A data não pode ser vazia.");
        }
        if (idUsuarios < 0 ) {
            errosValidacao.append("O idUsuarios deve ser válido.");
        }
        if (idTimes < 0 ) {
            errosValidacao.append("O idTimes deve ser válido.");
        }
        return errosValidacao.toString().trim();
    }
}
