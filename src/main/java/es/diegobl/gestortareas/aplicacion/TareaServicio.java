// Servicio que implementa la lógica de tareas: crear, actualizar y listar.
package es.diegobl.gestortareas.aplicacion;

import java.util.List;

import org.springframework.stereotype.Service;

import es.diegobl.gestortareas.dominio.Tarea;
import es.diegobl.gestortareas.dominio.TareaRepositorio;
import es.diegobl.gestortareas.infraestructura.errores.RecursoNoEncontradoException;

@Service
public class TareaServicio {
    private final TareaRepositorio tareas;

    public TareaServicio(TareaRepositorio tareas) { this.tareas = tareas; }

    public List<Tarea> listar() {
        return tareas.findAll();
    }

    public Tarea crear(String titulo, Long usuarioId) {
        return tareas.save(new Tarea(titulo, usuarioId));
    }

    public Tarea actualizarParcial(Long id, String nuevoTitulo, Boolean nuevaHecha) {
    Tarea tarea = tareas.findById(id)
        .orElseThrow(() -> new RecursoNoEncontradoException("La tarea " + id + " no existe"));
    if (nuevoTitulo != null && !nuevoTitulo.isBlank()) tarea.setTitulo(nuevoTitulo);
    if (nuevaHecha != null) tarea.setHecha(nuevaHecha);
    return tareas.save(tarea);
    }
}
