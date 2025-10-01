// Controlador REST que expone endpoints para listar, crear y actualizar tareas.
package es.diegobl.gestortareas.web.controladores;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.diegobl.gestortareas.aplicacion.TareaServicio;
import es.diegobl.gestortareas.dominio.Tarea;
import es.diegobl.gestortareas.web.dto.ActualizarTareaPeticion;
import es.diegobl.gestortareas.web.dto.CrearTareaPeticion;
import es.diegobl.gestortareas.web.dto.TareaRespuesta;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tareas")
public class TareaControlador {
    private final TareaServicio servicio;

    public TareaControlador(TareaServicio servicio) { this.servicio = servicio; }

    @GetMapping
    public List<TareaRespuesta> listar() {
        return servicio.listar().stream()
                .map(tarea -> new TareaRespuesta(tarea.getId(), tarea.getTitulo(), tarea.getHecha(), tarea.getUsuarioId()))
                .toList();
    }

    @PostMapping
    public ResponseEntity<TareaRespuesta> crear(@Valid @RequestBody CrearTareaPeticion peticion) {
        Tarea tarea = servicio.crear(peticion.getTitulo(), peticion.getUsuarioId());
        return ResponseEntity.ok(new TareaRespuesta(tarea.getId(), tarea.getTitulo(), tarea.getHecha(), tarea.getUsuarioId()));
    }

    @PatchMapping("/{id}")
    public TareaRespuesta actualizarParcial(@PathVariable Long id,
                                            @RequestBody ActualizarTareaPeticion peticion) {
        Tarea tarea = servicio.actualizarParcial(id, peticion.getTitulo(), peticion.getHecha());
        return new TareaRespuesta(tarea.getId(), tarea.getTitulo(), tarea.getHecha(), tarea.getUsuarioId());
    }
}
