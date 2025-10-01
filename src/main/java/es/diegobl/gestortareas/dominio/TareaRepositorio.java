package es.diegobl.gestortareas.dominio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepositorio extends JpaRepository<Tarea, Long> {
    Page<Tarea> findByUsuarioId(Long usuarioId, Pageable pageable);
}
