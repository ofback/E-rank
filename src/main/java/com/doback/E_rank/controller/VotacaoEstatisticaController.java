package com.doback.E_rank.controller;

import com.doback.E_rank.entity.VotacaoEstatistica;
import com.doback.E_rank.application.VotacaoEstatisticaApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/votacoes")
public class VotacaoEstatisticaController {

    private final VotacaoEstatisticaApplication votacaoEstatisticaApplication;

    public VotacaoEstatisticaController(VotacaoEstatisticaApplication votacaoEstatisticaApplication) {
        this.votacaoEstatisticaApplication = votacaoEstatisticaApplication;
    }

    @GetMapping
    public List<VotacaoEstatistica> listarVotacoes() {
        return votacaoEstatisticaApplication.obterTodasVotacoes();
    }

    @GetMapping("/{id}")
    public Optional<VotacaoEstatistica> obterVotacao(@PathVariable Long id) {
        return votacaoEstatisticaApplication.obterVotacaoPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VotacaoEstatistica criarVotacao(@RequestBody VotacaoEstatistica votacaoEstatistica) {
        return votacaoEstatisticaApplication.criarVotacao(votacaoEstatistica);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirVotacao(@PathVariable Long id) {
        votacaoEstatisticaApplication.excluirVotacao(id);
    }
}
