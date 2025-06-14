package io.github.Guimaraes131.arquiteturaspring.todos.controller;

import io.github.Guimaraes131.arquiteturaspring.todos.component.MailSender;
import io.github.Guimaraes131.arquiteturaspring.todos.component.TodoValidator;
import io.github.Guimaraes131.arquiteturaspring.todos.model.TodoEntity;
import io.github.Guimaraes131.arquiteturaspring.todos.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService service;

    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public TodoEntity post(@RequestBody TodoEntity todo) {
        try {
            return service.post(todo);
        } catch (IllegalArgumentException e) {
            var mensagemErro = e.getMessage();
            throw new ResponseStatusException(HttpStatus.CONFLICT, mensagemErro);
        }
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody TodoEntity todo) {
        todo.setId(id);
        this.service.updateStatus(todo);
    }

    @GetMapping("/{id}")
    public TodoEntity get(@PathVariable("id") Integer id) {
        return this.service.get(id);
    }
}
