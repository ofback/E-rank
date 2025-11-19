// E-rank/src/main/java/com/doback/E_rank/application/DesafiosApplication.java
package com.doback.E_rank.application;

import com.doback.E_rank.dto.CreateDesafioDTO;
import com.doback.E_rank.dto.DesafioResponseDTO;
import com.doback.E_rank.exceptions.ResourceNotFoundException;
import com.doback.E_rank.infrastructure.models.DesafiosModel;
import com.doback.E_rank.infrastructure.repository.jpa.DesafiosJpa;
import com.doback.E_rank.infrastructure.repository.jpa.UsuariosJpa;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DesafiosApplication {

    private final DesafiosJpa desafiosJpa;
    private final UsuariosJpa usuariosJpa;

    public DesafiosApplication(DesafiosJpa desafiosJpa, UsuariosJpa usuariosJpa) {
        this.desafiosJpa = desafiosJpa;
        this.usuariosJpa = usuariosJpa;
    }

    @Transactional
    public void criarDesafio(CreateDesafioDTO dto, int desafianteId) {
        if (dto.getDesafiadoId() == desafianteId) {
            throw new IllegalArgumentException("Você não pode desafiar a si mesmo.");
        }

        if (!usuariosJpa.existsById(dto.getDesafiadoId())) {
            throw new ResourceNotFoundException("Usuário desafiado não encontrado.");
        }

        DesafiosModel model = new DesafiosModel();
        model.setDesafianteId(desafianteId);
        model.setDesafiadoId(dto.getDesafiadoId());
        model.setStatus("P"); // Pendente
        model.setDataHora(LocalDateTime.now());

        desafiosJpa.save(model);
    }

    public List<DesafioResponseDTO> listarPendentes(int userId) {
        return desafiosJpa.findByDesafiadoIdAndStatus(userId, "P").stream()
                .map(d -> new DesafioResponseDTO(
                        d.getId(),
                        d.getDesafiante().getNickname(),
                        d.getStatus(),
                        d.getDataHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))
                ))
                .collect(Collectors.toList());
    }

    @Transactional
    public void responderDesafio(int desafioId, int userId, boolean aceitar) {
        DesafiosModel desafio = desafiosJpa.findById(desafioId)
                .orElseThrow(() -> new ResourceNotFoundException("Desafio não encontrado."));

        if (desafio.getDesafiadoId() != userId) {
            throw new IllegalArgumentException("Este desafio não é para você.");
        }

        if (!"P".equals(desafio.getStatus())) {
            throw new IllegalStateException("O desafio não está mais pendente.");
        }

        desafio.setStatus(aceitar ? "A" : "R");
        desafiosJpa.save(desafio);
    }
}