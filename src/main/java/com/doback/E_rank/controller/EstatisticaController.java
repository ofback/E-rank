package com.doback.E_rank.controller;

import com.doback.E_rank.entity.Estatistica;
import com.doback.E_rank.facade.EstatisticaFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estatisticas")
public class EstatisticaController {
    private final EstatisticaFacade estatisticaFacade;

    public EstatisticaController(EstatisticaFacade estatisticaFacade) {
        this.estatisticaFacade = estatisticaFacade;
    }

    @GetMapping
    public List<Estatistica> listarEstatisticas() {
        return estatisticaFacade.listarEstatisticas();
    }

    @GetMapping("/{id}")
    public Estatistica obterEstatistica(@PathVariable Long id) {
        return estatisticaFacade.buscarEstatisticaPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarEstatistica(@RequestBody Estatistica estatistica) {
        estatisticaFacade.salvarEstatistica(estatistica);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirEstatistica(@PathVariable Long id) {
        estatisticaFacade.excluirEstatistica(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarEstatistica(@PathVariable Long id, @RequestBody Estatistica estatistica) {
        estatisticaFacade.atualizarEstatistica(id, estatistica);
    }
}