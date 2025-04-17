package com.doback.E_rank.controller;

import com.doback.E_rank.models.Desafios;
import com.doback.E_rank.facade.DesafiosFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desafios")
public class DesafiosController {
    private final DesafiosFacade desafioFacade;

    public DesafiosController(DesafiosFacade desafioFacade) {
        this.desafioFacade = desafioFacade;
    }

    @GetMapping
    public List<Desafios> listarDesafios() {
        return desafioFacade.listarDesafios();
    }

    @GetMapping("/{id}")
    public Desafios obterDesafio(@PathVariable int id) {
        return desafioFacade.buscarDesafioPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarDesafio(@RequestBody Desafios desafio) {
        desafioFacade.salvarDesafio(desafio);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirDesafio(@PathVariable int id) {
        desafioFacade.excluirDesafio(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarDesafios(@PathVariable int id,@RequestBody Desafios desafios){
        desafioFacade.atualizarDesafio(id, desafios);
    }
}
