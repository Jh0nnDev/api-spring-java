package com.claudio.tarefas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Integer id) {
        return repository.findById(id)
                .map(tarefa -> ResponseEntity.ok(tarefa))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> buscarTarefas() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@Valid @RequestBody Tarefa tarefa) {
        Tarefa nova = repository.save(tarefa);
        return ResponseEntity.status(201).body(nova);
    }

    @PutMapping("/{id}")
    ResponseEntity<Tarefa> atualizarTarefa(@RequestBody Tarefa tarefa, @PathVariable Integer id) {
        return repository.findById(id)
                .map(trf -> {
                    trf.setTitulo_tarefa(tarefa.getTitulo_tarefa());
                    return ResponseEntity.ok(repository.save(trf));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarTarefa(@PathVariable Integer id) {
        return repository.findById(id)
                .map(tarefa -> {
                    repository.deleteById(id);
                    return ResponseEntity.<Void>noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
        }
    }