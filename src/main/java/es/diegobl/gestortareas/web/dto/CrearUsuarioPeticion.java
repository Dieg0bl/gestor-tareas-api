// DTO que representa la petición para crear un usuario; valida nombre y email.
package es.diegobl.gestortareas.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class CrearUsuarioPeticion {
    @NotBlank(message = "El nombre es obligatorio")
    public String nombre;

    @Email(message = "Email inválido")
    @NotBlank(message = "El email es obligatorio")
    public String email;
}
