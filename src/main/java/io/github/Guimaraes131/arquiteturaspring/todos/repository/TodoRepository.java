package io.github.Guimaraes131.arquiteturaspring.todos.repository;

import io.github.Guimaraes131.arquiteturaspring.todos.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {
    boolean existsByDescricao(String descricao);
}
