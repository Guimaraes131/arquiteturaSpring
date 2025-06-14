package io.github.Guimaraes131.arquiteturaspring.todos.component;

import org.springframework.stereotype.Component;

@Component
public class MailSender {

    public void sendEmail(String mensagem) {
        System.out.println("Enviando email: " + mensagem);
    }
}
