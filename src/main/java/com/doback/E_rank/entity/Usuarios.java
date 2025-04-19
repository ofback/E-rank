package com.doback.E_rank.entity;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class Usuarios {

        private int id;

        private String nome;

        private String cpf;

        private String dataNascimento;

        private String email;

        private String nickname;

        private String senha;

        private String biografia;

        private char sts;

        private Date dataCriacao;

        public Usuarios(String nome, String cpf, String dataNascimento, String email, String nickname, String senha, String biografia, char sts, Date dataCriacao) {
            this.nome = nome;
            this.cpf = cpf;
            this.dataNascimento = dataNascimento;
            this.email = email;
            this.nickname = nickname;
            this.senha = senha;
            this.biografia = biografia;
            this.sts = sts;
            this.dataCriacao = dataCriacao;
        }

        public Usuarios() {
        }


        public char getSts() {
            return sts;
        }

        public void setSts(char sts) {
            this.sts = sts;
        }

        public String getBiografia() {
            return biografia;
        }

        public void setBiografia(String biografia) {
            this.biografia = biografia;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }

        public Date getDataCriacao() {
            return dataCriacao;
        }

        public void setDataCriacao(Date dataCriacao) {
            this.dataCriacao = dataCriacao;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        public String getDataNascimento() {
            return dataNascimento;
        }

        public void setDataNascimento(String dataNascimento) {
            this.dataNascimento = dataNascimento;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean validarCPF() {
            String cpfNumeros = this.cpf.replaceAll("\\D", "");

            if (cpfNumeros.length() != 11 || cpfNumeros.matches("(\\d)\\1{10}")) {
                return false;
            }

            try {
                int digito1 = calcularDigitoVerificador(cpfNumeros, 10);
                int digito2 = calcularDigitoVerificador(cpfNumeros, 11);
                return digito1 == Character.getNumericValue(cpfNumeros.charAt(9)) &&
                        digito2 == Character.getNumericValue(cpfNumeros.charAt(10));
            } catch (NumberFormatException e) {
                return false;
            }
        }

        private int calcularDigitoVerificador(String cpf, int pesoInicial) {
            int soma = 0;
            for (int i = 0; i < pesoInicial - 1; i++) {
                soma += Character.getNumericValue(cpf.charAt(i)) * (pesoInicial - i);
            }
            int resultado = 11 - (soma % 11);
            return resultado > 9 ? 0 : resultado;
        }

        public boolean validarEmail() {
            if (this.email == null || this.email.trim().isEmpty()) return false;
            return this.email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        }

        public int calcularIdade() {
            if (this.dataNascimento == null || this.dataNascimento.trim().isEmpty()) return -1;

            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate nascimento = LocalDate.parse(this.dataNascimento, formatter);
                LocalDate hoje = LocalDate.now();

                if (nascimento.isAfter(hoje)) return -1;

                return Period.between(nascimento, hoje).getYears();
            } catch (DateTimeParseException e) {
                return -1;
            }
    }

}



