// Servicio que orquesta operaciones de negocio sobre usuarios (listar, obtener, crear).
package es.diegobl.gestortareas.aplicacion;

import java.util.List;

import org.springframework.stereotype.Service;

import es.diegobl.gestortareas.dominio.Usuario;
import es.diegobl.gestortareas.dominio.UsuarioRepositorio;
import es.diegobl.gestortareas.infraestructura.errores.ConflictoException;
import es.diegobl.gestortareas.infraestructura.errores.RecursoNoEncontradoException;

@Service
public class UsuarioServicio {
    private final UsuarioRepositorio usuarios;

    public UsuarioServicio(UsuarioRepositorio usuarios) { this.usuarios = usuarios; }

    public List<Usuario> listar() {
        return usuarios.findAll();
    }

    public Usuario obtener(Long id) {
        return usuarios.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("El usuario " + id + " no existe"));
    }

    public Usuario crear(String nombre, String email) {
        if (usuarios.existsByEmail(email)) {
            throw new ConflictoException("El email ya está registrado");
        }
        return usuarios.save(new Usuario(nombre, email));
    }
}
