package com.doback.E_rank.controller;

import com.doback.E_rank.entity.Amizade;
import com.doback.E_rank.application.AmizadeApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/amizades")
public class AmizadeController {

    private final AmizadeApplication amizadeApplication;

    public AmizadeController(AmizadeApplication amizadeApplication) {
        this.amizadeApplication = amizadeApplication;
    }

    @GetMapping
    public List<Amizade> listarAmizades() {
        return amizadeApplication.obterTodasAmizades();
    }

    @GetMapping("/{id}")
    public Optional<Amizade> obterAmizade(@PathVariable Long id) {
        return amizadeApplication.obterAmizadePorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Amizade criarAmizade(@RequestBody Amizade amizade) {
        return amizadeApplication.criarAmizade(amizade);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirAmizade(@PathVariable Long id) {
        amizadeApplication.excluirAmizade(id);
    }
}
