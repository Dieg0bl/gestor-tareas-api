package es.diegobl.gestortareas.infraestructura.inicializacion;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.diegobl.gestortareas.dominio.Tarea;
import es.diegobl.gestortareas.dominio.TareaRepositorio;
import es.diegobl.gestortareas.dominio.Usuario;
import es.diegobl.gestortareas.dominio.UsuarioRepositorio;

@Configuration
public class DatosDeEjemploConfig {
    // Registra datos de ejemplo en entornos locales si la BD aún no tiene usuarios.

    @Bean
    CommandLineRunner cargarDatos(UsuarioRepositorio usuarios, TareaRepositorio tareas) {
        return args -> {
            if (usuarios.count() == 0) {
                Usuario laura = usuarios.save(new Usuario("Laura Jiménez", "laura.jimenez@example.com"));
                Usuario carlos = usuarios.save(new Usuario("Carlos Navarro", "carlos.navarro@example.com"));
                Usuario elena = usuarios.save(new Usuario("Elena Ruiz", "elena.ruiz@example.com"));

                tareas.save(new Tarea("Revisar propuesta de diseño enviada por Marta", laura.getId()));
                tareas.save(new Tarea("Enviar recordatorio del comité de producto del jueves", laura.getId()));

                tareas.save(new Tarea("Actualizar inventario del almacén de la calle Toledo", carlos.getId()));
                tareas.save(new Tarea("Confirmar entrega con la mensajería para el lunes", carlos.getId()));

                tareas.save(new Tarea("Preparar agenda para la reunión con clientes de Valencia", elena.getId()));
                tareas.save(new Tarea("Archivar contratos firmados durante septiembre", elena.getId()));
            }
        };
    }
}
