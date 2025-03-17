package com.doback.E_rank.controller;

import com.doback.E_rank.entity.Desafio;
import com.doback.E_rank.facade.DesafioFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desafios")
public class DesafioController {
    private final DesafioFacade desafioFacade;

    public DesafioController(DesafioFacade desafioFacade) {
        this.desafioFacade = desafioFacade;
    }

    @GetMapping
    public List<Desafio> listarDesafios() {
        return desafioFacade.listarDesafios();
    }

    @GetMapping("/{id}")
    public Desafio obterDesafio(@PathVariable Long id) {
        return desafioFacade.buscarDesafioPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarDesafio(@RequestBody Desafio desafio) {
        desafioFacade.salvarDesafio(desafio);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirDesafio(@PathVariable Long id) {
        desafioFacade.excluirDesafio(id);
    }
}
