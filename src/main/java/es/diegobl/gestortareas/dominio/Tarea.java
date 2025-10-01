// Entidad JPA que representa una tarea con título, estado y usuario asociado.
package es.diegobl.gestortareas.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tareas")
public class Tarea {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotNull
    private Boolean hecha = false;

    @NotNull
    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    public Tarea() {}

    public Tarea(String titulo, Long usuarioId) {
        this.titulo = titulo;
        this.usuarioId = usuarioId;
        this.hecha = false;
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public Boolean getHecha() { return hecha; }
    public Long getUsuarioId() { return usuarioId; }
    public void setId(Long id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setHecha(Boolean hecha) { this.hecha = hecha; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
}
