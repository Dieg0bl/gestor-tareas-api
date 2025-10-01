// Controlador REST que expone endpoints para gestionar usuarios.
package es.diegobl.gestortareas.web.controladores;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.diegobl.gestortareas.aplicacion.UsuarioServicio;
import es.diegobl.gestortareas.dominio.Usuario;
import es.diegobl.gestortareas.web.dto.CrearUsuarioPeticion;
import es.diegobl.gestortareas.web.dto.UsuarioRespuesta;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioControlador {
    private final UsuarioServicio servicio;

    public UsuarioControlador(UsuarioServicio servicio) { this.servicio = servicio; }

    @GetMapping
    public java.util.List<UsuarioRespuesta> listar() {
        return servicio.listar().stream()
                .map(u -> new UsuarioRespuesta(u.getId(), u.getNombre(), u.getEmail()))
                .toList();
    }

    @GetMapping("/{id}")
    public UsuarioRespuesta obtener(@PathVariable Long id) {
        Usuario usuario = servicio.obtener(id);
        return new UsuarioRespuesta(usuario.getId(), usuario.getNombre(), usuario.getEmail());
    }

    @PostMapping
    public ResponseEntity<UsuarioRespuesta> crear(@Valid @RequestBody CrearUsuarioPeticion peticion) {
        Usuario usuario = servicio.crear(peticion.nombre, peticion.email);
        return ResponseEntity.ok(new UsuarioRespuesta(usuario.getId(), usuario.getNombre(), usuario.getEmail()));
    }
}
