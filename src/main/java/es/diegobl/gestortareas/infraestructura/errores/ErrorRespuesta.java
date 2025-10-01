package es.diegobl.gestortareas.infraestructura.errores;

import java.time.Instant;

public class ErrorRespuesta {
    private final Instant instante = Instant.now();
    private String ruta;
    private int estado;
    private String error;
    private String mensaje;

    public Instant getInstante() {
        return instante;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
