package com.doback.E_rank.controller;
import com.doback.E_rank.entity.FeedMensagens;
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
    public List<FeedMensagens> listaFeedMensagens() {
        return feedMensagensFacade.listarFeedMensagens();
    }

    @GetMapping("/{id}")
    public FeedMensagens obterFeedMensagens(@PathVariable int id) {
        return feedMensagensFacade.buscarFeedMensagensPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarFeedMensagens(@RequestBody FeedMensagens feedMensagens) {
        feedMensagensFacade.salvarFeedMensagens(feedMensagens);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirFeedMensagens(@PathVariable int id) {
        feedMensagensFacade.excluirFeedMensagens(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarFeedMensagens(@PathVariable int id, @RequestBody FeedMensagens feedMensagens) {
        feedMensagensFacade.atualizarFeedMensagens(id, feedMensagens);
    }
}
