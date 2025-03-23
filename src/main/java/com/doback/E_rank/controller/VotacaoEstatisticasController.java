package com.doback.E_rank.controller;
import com.doback.E_rank.entity.VotacaoEstatisticas;
import com.doback.E_rank.facade.VotacaoEstatisticasFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/votacaoEstatisticas")

public class VotacaoEstatisticasController {
    private final VotacaoEstatisticasFacade votacaoEstatisticasFacade;

    public VotacaoEstatisticasController(VotacaoEstatisticasFacade votacaoEstatisticasFacade) {
        this.votacaoEstatisticasFacade = votacaoEstatisticasFacade;
    }

    @GetMapping
    public List<VotacaoEstatisticas> listaVotacaoEstatisticas() {
        return votacaoEstatisticasFacade.listarVotacaoEstatisticas();
    }

    @GetMapping("/{id}")
    public VotacaoEstatisticas obterVotacaoEstatisticas(@PathVariable Long id) {
        return votacaoEstatisticasFacade.buscarVotacaoEstatisticasPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarVotacaoEstatisticas(@RequestBody VotacaoEstatisticas votacaoEstatisticas) {
        votacaoEstatisticasFacade.salvarVotacaoEstatisticas(votacaoEstatisticas);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirVotacaoEstatisticas(@PathVariable Long id) {
        votacaoEstatisticasFacade.excluirVotacaoEstatisticas(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarVotacaoEstatisticas(@PathVariable Long id, @RequestBody VotacaoEstatisticas votacaoEstatisticas) {
        votacaoEstatisticasFacade.atualizarVotacaoEstatisticas(id, votacaoEstatisticas);
    }
}
