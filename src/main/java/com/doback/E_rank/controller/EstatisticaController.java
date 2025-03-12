package com.doback.E_rank.controller;

import com.doback.E_rank.entity.Estatistica;
import com.doback.E_rank.application.EstatisticaApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estatisticas")
public class EstatisticaController {

    private final EstatisticaApplication estatisticaApplication;

    public EstatisticaController(EstatisticaApplication estatisticaApplication) {
        this.estatisticaApplication = estatisticaApplication;
    }

    @GetMapping
    public List<Estatistica> listarEstatisticas() {
        return estatisticaApplication.obterTodasEstatisticas();
    }

    @GetMapping("/{id}")
    public Optional<Estatistica> obterEstatistica(@PathVariable Long id) {
        return estatisticaApplication.obterEstatisticaPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estatistica criarEstatistica(@RequestBody Estatistica estatistica) {
        return estatisticaApplication.criarEstatistica(estatistica);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirEstatistica(@PathVariable Long id) {
        estatisticaApplication.excluirEstatistica(id);
    }
}
