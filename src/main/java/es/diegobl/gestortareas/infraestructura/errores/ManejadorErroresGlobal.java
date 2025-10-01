package es.diegobl.gestortareas.infraestructura.errores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ManejadorErroresGlobal {
    // Maneja excepciones y convierte errores en respuestas HTTP coherentes.

    @ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<ErrorRespuesta> notFound(RecursoNoEncontradoException excepcion, HttpServletRequest peticion) {
        return build(HttpStatus.NOT_FOUND, "No encontrado", excepcion.getMessage(), peticion.getRequestURI());
    }

    @ExceptionHandler(ConflictoException.class)
    public ResponseEntity<ErrorRespuesta> conflict(ConflictoException excepcion, HttpServletRequest peticion) {
        return build(HttpStatus.CONFLICT, "Conflicto", excepcion.getMessage(), peticion.getRequestURI());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorRespuesta> badRequest(MethodArgumentNotValidException excepcion, HttpServletRequest peticion) {
        String mensaje = excepcion.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return build(HttpStatus.BAD_REQUEST, "Petición inválida", mensaje, peticion.getRequestURI());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorRespuesta> generic(Exception excepcion, HttpServletRequest peticion) {
        return build(HttpStatus.INTERNAL_SERVER_ERROR, "Error interno", excepcion.getMessage(), peticion.getRequestURI());
    }

    private ResponseEntity<ErrorRespuesta> build(HttpStatus status, String error, String mensaje, String ruta) {
        ErrorRespuesta errorRespuesta = new ErrorRespuesta();
        errorRespuesta.setEstado(status.value());
        errorRespuesta.setError(error);
        errorRespuesta.setMensaje(mensaje);
        errorRespuesta.setRuta(ruta);
        return ResponseEntity.status(status).body(errorRespuesta);
    }
}
