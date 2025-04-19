package com.doback.E_rank.entity;

import com.doback.E_rank.models.EstatisticasModel;
import com.doback.E_rank.models.TemporadasModel;
import com.doback.E_rank.models.UsuariosModel;

import java.sql.*;
import java.util.Date;

public class VotacaoEstatisticas {
        private int id;

        private boolean voto;

        private Date data_voto;

        private EstatisticasModel estatisticasModel;

        private UsuariosModel usuariosModel;

        private TemporadasModel temporadasModel;


        public VotacaoEstatisticas(boolean voto, Date data_voto, EstatisticasModel estatisticasModel, UsuariosModel usuariosModel, TemporadasModel temporadasModel) {
            this.voto = voto;
            this.data_voto = data_voto;
            this.estatisticasModel = estatisticasModel;
            this.usuariosModel = usuariosModel;
            this.temporadasModel = temporadasModel;
        }

        public VotacaoEstatisticas() {
        }

        public boolean isVoto() {
            return voto;
        }

        public void setVoto(boolean voto) {
            this.voto = voto;
        }

        public Date getData_voto() {
            return data_voto;
        }

        public void setData_voto(Date data_voto) {
            this.data_voto = data_voto;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public EstatisticasModel getEstatisticasModel() {
            return estatisticasModel;
        }

        public void setEstatisticasModel(EstatisticasModel estatisticasModel) {
            this.estatisticasModel = estatisticasModel;
        }

        public UsuariosModel getUsuariosModel() {
            return usuariosModel;
        }

        public void setUsuariosModel(UsuariosModel usuariosModel) {
            this.usuariosModel = usuariosModel;
        }

        public static void validarVotoDuplicado(boolean jaVotou) {
            if (jaVotou) {
                throw new IllegalArgumentException("Este usuário já votou nesta estatística.");
            }
        }

        public static void validarSePodeVotar(Date dataLimite) {
            Date hoje = new Date();
            if (hoje.after(dataLimite)) {
                throw new IllegalArgumentException("O período de votação já foi encerrado.");
            }
        }

}
