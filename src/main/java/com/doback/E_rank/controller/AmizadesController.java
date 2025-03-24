package com.doback.E_rank.controller;

import com.doback.E_rank.entity.Amizades;
import com.doback.E_rank.entity.Times;
import com.doback.E_rank.facade.AmizadesFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/amizades")
public class AmizadesController {

    private final AmizadesFacade amizadeFacade;

    public AmizadesController(AmizadesFacade amizadeFacade) {
        this.amizadeFacade = amizadeFacade;
    }

    @GetMapping
    public List<Amizades> listarAmizades() {
        return amizadeFacade.listarAmizades();
    }

    @GetMapping("/{id}")
    public Amizades obterAmizade(@PathVariable int id) {
        return amizadeFacade.buscarAmizadePorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAmizade(@RequestBody Amizades amizade) {
        amizadeFacade.salvarAmizade(amizade);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirAmizade(@PathVariable int id) {
        amizadeFacade.excluirAmizade(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarAmizades(@PathVariable int id,@RequestBody Amizades amizades){
        amizadeFacade.atualizarAmizades(id, amizades);
    }

}
