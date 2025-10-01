package es.diegobl.gestortareas.infraestructura.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI().info(new Info()
                .title("Gestor de Tareas API")
                .description("API sencilla de usuarios y tareas para fines educativos")
                .version("0.1.0"));
    }
}
