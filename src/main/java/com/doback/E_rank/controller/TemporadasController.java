package com.doback.E_rank.controller;
import com.doback.E_rank.infrastructure.models.TemporadasModel;
import com.doback.E_rank.facade.TemporadasFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/temporadas")
public class TemporadasController {

    private final TemporadasFacade temporadaFacade;

    public TemporadasController(TemporadasFacade temporadaFacade) {
        this.temporadaFacade = temporadaFacade;
    }

    @GetMapping
    public List<TemporadasModel> listarTemporadas() {
        return temporadaFacade.listarTemporadas();
    }

    @GetMapping("/{id}")
    public TemporadasModel obterTemporadas(@PathVariable int id) {
        return temporadaFacade.buscarTemporadaPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarTemporada(@RequestBody TemporadasModel temporada) {
        temporadaFacade.salvarTemporada(temporada);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirTemporada(@PathVariable int id) { temporadaFacade.excluirTemporada(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarTemporadas(@PathVariable int id, @RequestBody TemporadasModel temporadasModel) {
        temporadaFacade.atualizarTemporadas(id, temporadasModel);
    }


}
