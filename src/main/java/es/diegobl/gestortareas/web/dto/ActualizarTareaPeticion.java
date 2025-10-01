package es.diegobl.gestortareas.web.dto;

public class ActualizarTareaPeticion {
    private String titulo;
    private Boolean hecha;

    public ActualizarTareaPeticion() {
    } 

    public ActualizarTareaPeticion(String titulo, Boolean hecha) {
        this.titulo = titulo; 
        this.hecha = hecha; 
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Boolean getHecha() {
        return hecha;
    }

    public void setHecha(Boolean hecha) {
        this.hecha = hecha;
    }
}
