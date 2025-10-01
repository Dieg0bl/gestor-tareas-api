// DTO que representa la petición para crear una tarea; valida título y usuarioId.
package es.diegobl.gestortareas.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CrearTareaPeticion {
    @NotBlank(message = "El título es obligatorio")
    private String titulo;
    @NotNull(message = "El usuarioId es obligatorio")
    private Long usuarioId;
    public CrearTareaPeticion(String titulo, Long usuarioId) {
        this.titulo = titulo;
        this.usuarioId = usuarioId;
    }

    public CrearTareaPeticion() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
