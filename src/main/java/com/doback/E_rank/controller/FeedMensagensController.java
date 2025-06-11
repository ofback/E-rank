package com.doback.E_rank.controller;
import com.doback.E_rank.infrastructure.models.FeedMensagensModel;
import com.doback.E_rank.facade.FeedMensagensFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/feedMensagens")

public class FeedMensagensController {
    private final FeedMensagensFacade feedMensagensFacade;

    public FeedMensagensController(FeedMensagensFacade feedMensagensFacade) {
        this.feedMensagensFacade = feedMensagensFacade;
    }

    @GetMapping
    public List<FeedMensagensModel> listaFeedMensagens() {
        return feedMensagensFacade.listarFeedMensagens();
    }

    @GetMapping("/{id}")
    public FeedMensagensModel obterFeedMensagens(@PathVariable int id) {
        return feedMensagensFacade.buscarFeedMensagensPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarFeedMensagens(@RequestBody FeedMensagensModel feedMensagensModel) {
        feedMensagensFacade.salvarFeedMensagens(feedMensagensModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirFeedMensagens(@PathVariable int id) {
        feedMensagensFacade.excluirFeedMensagens(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarFeedMensagens(@PathVariable int id, @RequestBody FeedMensagensModel feedMensagensModel) {
        feedMensagensFacade.atualizarFeedMensagens(id, feedMensagensModel);
    }
}
