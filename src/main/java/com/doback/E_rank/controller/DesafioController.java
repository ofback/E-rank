package com.doback.E_rank.controller;

import com.doback.E_rank.entity.Desafio;
import com.doback.E_rank.application.DesafioApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/desafios")
public class DesafioController {

    private final DesafioApplication desafioApplication;

    public DesafioController(DesafioApplication desafioApplication) {
        this.desafioApplication = desafioApplication;
    }

    @GetMapping
    public List<Desafio> listarDesafios() {
        return desafioApplication.obterTodosDesafios();
    }

    @GetMapping("/{id}")
    public Optional<Desafio> obterDesafio(@PathVariable Long id) {
        return desafioApplication.obterDesafioPorId(id);
    }

    @GetMapping("/status/{status}")
    public List<Desafio> listarDesafiosPorStatus(@PathVariable Desafio.StatusDesafio status) {
        return desafioApplication.obterDesafiosPorStatus(status);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Desafio criarDesafio(@RequestBody Desafio desafio) {
        return desafioApplication.criarDesafio(desafio);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirDesafio(@PathVariable Long id) {
        desafioApplication.excluirDesafio(id);
    }
}
