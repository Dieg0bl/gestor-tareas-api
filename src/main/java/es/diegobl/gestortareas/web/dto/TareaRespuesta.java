package es.diegobl.gestortareas.web.dto;

public class TareaRespuesta {
    private Long id;
    private String titulo;
    private Boolean hecha;
    private Long usuarioId;

    public TareaRespuesta(Long id, String titulo, Boolean hecha, Long usuarioId) {
        this.id = id;
        this.titulo = titulo;
        this.hecha = hecha;
        this.usuarioId = usuarioId;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Boolean getHecha() {
        return hecha;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }
}
