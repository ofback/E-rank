package com.doback.E_rank.controller;
import com.doback.E_rank.infrastructure.models.VotacaoEstatisticasModel;
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
    public List<VotacaoEstatisticasModel> listaVotacaoEstatisticas() {
        return votacaoEstatisticasFacade.listarVotacaoEstatisticas();
    }

    @GetMapping("/{id}")
    public VotacaoEstatisticasModel obterVotacaoEstatisticas(@PathVariable int id) {
        return votacaoEstatisticasFacade.buscarVotacaoEstatisticasPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarVotacaoEstatisticas(@RequestBody VotacaoEstatisticasModel votacaoEstatisticasModel) {
        votacaoEstatisticasFacade.salvarVotacaoEstatisticas(votacaoEstatisticasModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirVotacaoEstatisticas(@PathVariable int id) {
        votacaoEstatisticasFacade.excluirVotacaoEstatisticas(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarVotacaoEstatisticas(@PathVariable int id, @RequestBody VotacaoEstatisticasModel votacaoEstatisticasModel) {
        votacaoEstatisticasFacade.atualizarVotacaoEstatisticas(id, votacaoEstatisticasModel);
    }
}
