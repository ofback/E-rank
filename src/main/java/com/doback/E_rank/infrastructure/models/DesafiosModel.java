// E-rank/src/main/java/com/doback/E_rank/infrastructure/models/DesafiosModel.java
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
    private String status; // Substitui 'sts'. Valores: P, A, R, C

    @Column(name = "data_hora")
    private LocalDateTime dataHora; // Substitui 'dataDesafio'

    @Column(name = "resultado")
    private String resultado; // Novo campo para armazenar o placar/resultado

    // Relacionamento (apenas leitura) para facilitar pegar o nome do desafiante
    @ManyToOne
    @JoinColumn(name = "id_desafiante", insertable = false, updatable = false)
    private UsuariosModel desafiante;
}