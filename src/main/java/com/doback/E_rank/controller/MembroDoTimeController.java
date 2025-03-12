package com.doback.E_rank.controller;

import com.doback.E_rank.entity.MembroDoTime;
import com.doback.E_rank.application.MembroDoTimeApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/membros")
public class MembroDoTimeController {

    private final MembroDoTimeApplication membroDoTimeApplication;

    public MembroDoTimeController(MembroDoTimeApplication membroDoTimeApplication) {
        this.membroDoTimeApplication = membroDoTimeApplication;
    }

    @GetMapping
    public List<MembroDoTime> listarMembros() {
        return membroDoTimeApplication.obterTodosMembros();
    }

    @GetMapping("/{id}")
    public Optional<MembroDoTime> obterMembro(@PathVariable Long id) {
        return membroDoTimeApplication.obterMembroPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MembroDoTime criarMembro(@RequestBody MembroDoTime membroDoTime) {
        return membroDoTimeApplication.criarMembro(membroDoTime);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirMembro(@PathVariable Long id) {
        membroDoTimeApplication.excluirMembro(id);
    }
}
