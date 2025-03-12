package com.doback.E_rank.controller;

import com.doback.E_rank.entity.Temporada;
import com.doback.E_rank.application.TemporadaApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/temporadas")
public class TemporadaController {

    private final TemporadaApplication temporadaApplication;

    public TemporadaController(TemporadaApplication temporadaApplication) {
        this.temporadaApplication = temporadaApplication;
    }

    @GetMapping
    public List<Temporada> listarTemporadas() {
        return temporadaApplication.obterTodasTemporadas();
    }

    @GetMapping("/{id}")
    public Optional<Temporada> obterTemporada(@PathVariable Long id) {
        return temporadaApplication.obterTemporadaPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Temporada criarTemporada(@RequestBody Temporada temporada) {
        return temporadaApplication.criarTemporada(temporada);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirTemporada(@PathVariable Long id) {
        temporadaApplication.excluirTemporada(id);
    }
}
