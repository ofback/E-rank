package com.doback.E_rank.controller;

import com.doback.E_rank.entity.FeedMensagens;
import com.doback.E_rank.application.FeedMensagensApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/feed")
public class FeedMensagensController {

    private final FeedMensagensApplication feedMensagensApplication;

    public FeedMensagensController(FeedMensagensApplication feedMensagensApplication) {
        this.feedMensagensApplication = feedMensagensApplication;
    }

    @GetMapping
    public List<FeedMensagens> listarFeedMensagens() {
        return feedMensagensApplication.obterTodosFeedMensagens();
    }

    @GetMapping("/{id}")
    public Optional<FeedMensagens> obterFeedMensagem(@PathVariable Long id) {
        return feedMensagensApplication.obterFeedMensagemPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FeedMensagens criarFeedMensagem(@RequestBody FeedMensagens feedMensagens) {
        return feedMensagensApplication.criarFeedMensagem(feedMensagens);
    }
}
