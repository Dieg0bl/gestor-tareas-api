package es.diegobl.gestortareas.infraestructura.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration configuracionCors = new CorsConfiguration();
        configuracionCors.addAllowedOriginPattern("*");
        configuracionCors.addAllowedHeader("*");
        configuracionCors.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource fuenteConfiguracion = new UrlBasedCorsConfigurationSource();
        fuenteConfiguracion.registerCorsConfiguration("/**", configuracionCors);
        return new CorsFilter(fuenteConfiguracion);
    }
}
