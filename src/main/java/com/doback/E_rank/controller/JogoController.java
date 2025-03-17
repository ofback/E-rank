package com.doback.E_rank.controller;

import com.doback.E_rank.entity.Jogo;
import com.doback.E_rank.facade.JogoFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/jogos")
public class JogoController {

    private final JogoFacade jogoFacade;

    public JogoController(JogoFacade jogoFacade) {
        this.jogoFacade = jogoFacade;
    }

    @GetMapping
    public List<Jogo> listaJogos() {
        return jogoFacade.listarJogos();
    }

    @GetMapping("/{id}")
    public Jogo obterJogo(@PathVariable Long id) {
        return jogoFacade.buscarJogoPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarJogo(@RequestBody Jogo jogo) {
        jogoFacade.salvarJogo(jogo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirJogo(@PathVariable Long id) {
        jogoFacade.excluirJogo(id);
    }
}
