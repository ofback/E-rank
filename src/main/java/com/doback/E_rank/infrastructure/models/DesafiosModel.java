package com.doback.E_rank.infrastructure.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB_DESAFIOS")
public class DesafiosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_desafiante")
    private int desafianteId;

    @Column(name = "id_desafiado")
    private int desafiadoId;

    @Column(length = 1)
    private String status;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    @Column(name = "resultado")
    private String resultado;

    @ManyToOne
    @JoinColumn(name = "id_desafiante", insertable = false, updatable = false)
    private UsuariosModel desafiante;

    @ManyToOne
    @JoinColumn(name = "id_desafiado", insertable = false, updatable = false)
    private UsuariosModel desafiado;

    @ManyToOne
    @JoinColumn(name = "id_amizade")
    private AmizadesModel amizadesModel;

    @ManyToOne
    @JoinColumn(name = "id_jogo")
    private JogosModel jogosModel;
}