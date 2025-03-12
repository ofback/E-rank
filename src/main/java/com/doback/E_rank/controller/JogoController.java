package com.doback.E_rank.controller;

import com.doback.E_rank.entity.Jogo;
import com.doback.E_rank.application.JogoApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jogos")
public class JogoController {

    private final JogoApplication jogoApplication;

    public JogoController(JogoApplication jogoApplication) {
        this.jogoApplication = jogoApplication;
    }

    @GetMapping
    public List<Jogo> listarJogos() {
        return jogoApplication.obterTodosJogos();
    }

    @GetMapping("/{id}")
    public Optional<Jogo> obterJogo(@PathVariable Long id) {
        return jogoApplication.obterJogoPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jogo criarJogo(@RequestBody Jogo jogo) {
        return jogoApplication.criarJogo(jogo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirJogo(@PathVariable Long id) {
        jogoApplication.excluirJogo(id);
    }
}
