package com.doback.E_rank.controller;

import com.doback.E_rank.infrastructure.models.EstatisticasModel;
import com.doback.E_rank.facade.EstatisticasFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estatisticas")
public class EstatisticasController {
    private final EstatisticasFacade estatisticaFacade;

    public EstatisticasController(EstatisticasFacade estatisticaFacade) {
        this.estatisticaFacade = estatisticaFacade;
    }

    @GetMapping
    public List<EstatisticasModel> listarEstatisticas() {
        return estatisticaFacade.listarEstatisticas();
    }

    @GetMapping("/{id}")
    public EstatisticasModel obterEstatistica(@PathVariable int id) {
        return estatisticaFacade.buscarEstatisticaPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarEstatistica(@RequestBody EstatisticasModel estatistica) {
        estatisticaFacade.salvarEstatistica(estatistica);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirEstatistica(@PathVariable int id) {
        estatisticaFacade.excluirEstatistica(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarEstatistica(@PathVariable int id, @RequestBody EstatisticasModel estatistica) {
        estatisticaFacade.atualizarEstatistica(id, estatistica);
    }
}