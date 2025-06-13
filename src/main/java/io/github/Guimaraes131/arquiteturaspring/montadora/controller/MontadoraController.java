package io.github.Guimaraes131.arquiteturaspring.montadora.controller;

import io.github.Guimaraes131.arquiteturaspring.montadora.annotations.Aspirado;
import io.github.Guimaraes131.arquiteturaspring.montadora.annotations.Eletrico;
import io.github.Guimaraes131.arquiteturaspring.montadora.annotations.Turbo;
import io.github.Guimaraes131.arquiteturaspring.montadora.model.CarroStatus;
import io.github.Guimaraes131.arquiteturaspring.montadora.model.Chave;
import io.github.Guimaraes131.arquiteturaspring.montadora.model.HondaHRV;
import io.github.Guimaraes131.arquiteturaspring.montadora.model.Motor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carros")
public class MontadoraController {

    @Autowired
    @Eletrico
    private Motor motor;

    @PostMapping
    public CarroStatus iniciarCarro(@RequestBody Chave chave) {
        var carro = new HondaHRV(motor);

        return carro.darIgnicao(chave);
    }
}
