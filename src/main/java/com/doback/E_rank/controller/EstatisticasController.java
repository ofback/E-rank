package com.doback.E_rank.controller;

import com.doback.E_rank.entity.Estatisticas;
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
    public List<Estatisticas> listarEstatisticas() {
        return estatisticaFacade.listarEstatisticas();
    }

    @GetMapping("/{id}")
    public Estatisticas obterEstatistica(@PathVariable Long id) {
        return estatisticaFacade.buscarEstatisticaPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarEstatistica(@RequestBody Estatisticas estatistica) {
        estatisticaFacade.salvarEstatistica(estatistica);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirEstatistica(@PathVariable Long id) {
        estatisticaFacade.excluirEstatistica(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarEstatistica(@PathVariable Long id, @RequestBody Estatisticas estatistica) {
        estatisticaFacade.atualizarEstatistica(id, estatistica);
    }
}