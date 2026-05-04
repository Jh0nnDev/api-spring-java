package com.claudio.tarefas;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "tarefas")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "O título não pode ser vazio")
    private String titulo_tarefa;

    public Integer getId() {
        return id;
    }

    public String getTitulo_tarefa() {
        return titulo_tarefa;
    }

    public void setTitulo_tarefa(String titulo_tarefa) {
        this.titulo_tarefa = titulo_tarefa;
    }

}