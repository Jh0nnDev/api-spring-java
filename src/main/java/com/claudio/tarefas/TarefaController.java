package com.claudio.tarefas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository repository;

    @GetMapping
    public List<Tarefa> buscarTarefas() {
        return repository.findAll();
    }

    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        return repository.save(tarefa);
    }

    @PutMapping("/{id}")
    Tarefa atualizarTarefa(@RequestBody Tarefa tarefa, @PathVariable Integer id) {
        return repository.findById(id)
                .map(trf -> {
                    trf.setTitulo_tarefa(tarefa.getTitulo_tarefa());
                    return repository.save(trf);
                })
                .orElseGet(() -> {
                    return repository.save(tarefa);
                });
    }

    @DeleteMapping("/{id}")
    Tarefa deletarTarefa(@PathVariable Integer id){
        return repository.delete(id);
    }


}