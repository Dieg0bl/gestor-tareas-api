package es.diegobl.gestortareas;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

import es.diegobl.gestortareas.aplicacion.UsuarioServicio;
import es.diegobl.gestortareas.dominio.UsuarioRepositorio;
import es.diegobl.gestortareas.infraestructura.errores.ConflictoException;

public class UsuarioServicioTest {
    @Test
    void noPermiteEmailDuplicado_whenEmailExists() {
        var repo = Mockito.mock(UsuarioRepositorio.class);
        when(repo.existsByEmail("lucia@example.com")).thenReturn(true);
        var servicio = new UsuarioServicio(repo);
        assertThrows(ConflictoException.class,
                () -> servicio.crear("Lucía", "lucia@example.com"));
    }
}
