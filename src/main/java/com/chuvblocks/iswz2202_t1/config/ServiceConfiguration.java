package com.chuvblocks.iswz2202_t1.config;

import com.chuvblocks.iswz2202_t1.service.IUsuarioService;
import com.chuvblocks.iswz2202_t1.service.TimingUsuarioServiceDecorator;
import com.chuvblocks.iswz2202_t1.service.UsuarioService;
import com.chuvblocks.iswz2202_t1.service.LoggingUsuarioServiceDecorator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ServiceConfiguration {

    @Bean
    @Primary
    public IUsuarioService usuarioServiceDecorator(UsuarioService usuarioService) {
        return new TimingUsuarioServiceDecorator(new LoggingUsuarioServiceDecorator(usuarioService));
    }
}