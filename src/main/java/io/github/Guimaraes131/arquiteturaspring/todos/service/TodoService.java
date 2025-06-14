package io.github.Guimaraes131.arquiteturaspring.todos.service;

import io.github.Guimaraes131.arquiteturaspring.todos.component.MailSender;
import io.github.Guimaraes131.arquiteturaspring.todos.component.TodoValidator;
import io.github.Guimaraes131.arquiteturaspring.todos.model.TodoEntity;
import io.github.Guimaraes131.arquiteturaspring.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository repository;
    private TodoValidator validator;
    private MailSender mailSender;

    @Autowired
    public TodoService(TodoRepository repository, TodoValidator validator, MailSender mailSender) {
        this.repository = repository;
        this.validator = validator;
        this.mailSender = mailSender;
    }

    public TodoEntity post(TodoEntity todo) {
        this.validator.validar(todo);
        this.mailSender.sendEmail("Cadastrando TODO '" + todo.getDescricao() + "'");

        return this.repository.save(todo);
    }

    public void updateStatus(TodoEntity todo) {
        this.mailSender.sendEmail("Atualizando TODO '" + todo.getDescricao() + "'");
        this.repository.save(todo);
    }

    public TodoEntity get(Integer id) {
        return this.repository.findById(id).orElse(null);
    }
}
