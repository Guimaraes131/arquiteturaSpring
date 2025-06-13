package io.github.Guimaraes131.arquiteturaspring.montadora.configuration;

import io.github.Guimaraes131.arquiteturaspring.montadora.annotations.Aspirado;
import io.github.Guimaraes131.arquiteturaspring.montadora.annotations.Eletrico;
import io.github.Guimaraes131.arquiteturaspring.montadora.annotations.Turbo;
import io.github.Guimaraes131.arquiteturaspring.montadora.model.Motor;
import io.github.Guimaraes131.arquiteturaspring.montadora.model.TipoMotor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MontadoraConfiguration {

    @Primary
    @Bean
    @Aspirado
    public Motor motorAspirado() {
        var motor = new Motor();
        motor.setModelo("XPTO-0");
        motor.setCavalos(120);
        motor.setTipoMotor(TipoMotor.ASPIRADO);
        motor.setCilindros(4);
        motor.setLitragem(1.4);

        return motor;
    }

    @Bean
    @Eletrico
    public Motor motorEletrico() {
        var motor = new Motor();
        motor.setModelo("TH-40");
        motor.setCavalos(130);
        motor.setTipoMotor(TipoMotor.ELETRICO);
        motor.setCilindros(5);
        motor.setLitragem(1.4);

        return motor;
    }

    @Bean
    @Turbo
    public Motor motorTurbo() {
        var motor = new Motor();
        motor.setModelo("XPTO-10");
        motor.setCavalos(150);
        motor.setTipoMotor(TipoMotor.TURBO);
        motor.setCilindros(4);
        motor.setLitragem(1.6);

        return motor;
    }
}
