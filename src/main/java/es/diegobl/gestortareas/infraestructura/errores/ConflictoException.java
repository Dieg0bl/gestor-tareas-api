package es.diegobl.gestortareas.infraestructura.errores;

public class ConflictoException extends RuntimeException {
    public ConflictoException(String mensaje) { super(mensaje); }
}
