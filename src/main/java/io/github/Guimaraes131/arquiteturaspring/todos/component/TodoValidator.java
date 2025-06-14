package io.github.Guimaraes131.arquiteturaspring.todos.component;

import io.github.Guimaraes131.arquiteturaspring.todos.model.TodoEntity;
import io.github.Guimaraes131.arquiteturaspring.todos.repository.TodoRepository;
import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    private TodoRepository repository;

    public TodoValidator(TodoRepository repository) {
        this.repository = repository;
    }

    public void validar(TodoEntity todo) {
        if (existePorDescricao(todo.getDescricao())) {
            throw new IllegalArgumentException("Já existe um TODO com essa descrição");
        }
    }

    private boolean existePorDescricao(String descricao) {
        return this.repository.existsByDescricao(descricao);
    }

}
