package com.doback.E_rank.controller;

import com.doback.E_rank.entity.Temporada;
import com.doback.E_rank.facade.TemporadaFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Temporadas")
public class TemporadaController {

    private final TemporadaFacade temporadaFacade;

    public TemporadaController(TemporadaFacade temporadaFacade) {
        this.temporadaFacade = temporadaFacade;
    }

    @GetMapping
    public List<Temporada> listarTemporadas() {
        return temporadaFacade.listarTemporadas();
    }

    @GetMapping("/{id}")
    public Temporada obterTemporadas(@PathVariable Long id) {
        return temporadaFacade.buscarTemporadaPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarTemporada(@RequestBody Temporada temporada) {
        temporadaFacade.salvarTemporada(temporada);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirTemporada(@PathVariable Long id) { temporadaFacade.excluirTemporada(id);
    }


}
