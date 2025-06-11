package com.doback.E_rank.controller;
import com.doback.E_rank.infrastructure.models.JogosModel;
import com.doback.E_rank.facade.JogosFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/jogos")
public class JogosController {

    private final JogosFacade jogoFacade;

    public JogosController(JogosFacade jogoFacade) {
        this.jogoFacade = jogoFacade;
    }

    @GetMapping
    public List<JogosModel> listaJogos() {
        return jogoFacade.listarJogos();
    }

    @GetMapping("/{id}")
    public JogosModel obterJogo(@PathVariable int id) {
        return jogoFacade.buscarJogoPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarJogo(@RequestBody JogosModel jogo) {
        jogoFacade.salvarJogo(jogo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirJogo(@PathVariable int id) {
        jogoFacade.excluirJogo(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarJogos(@PathVariable int id, @RequestBody JogosModel jogosModel) {
        jogoFacade.atualizarJogos(id, jogosModel);
    }
}
