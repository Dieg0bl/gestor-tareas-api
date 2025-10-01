# gestor-tareas-api

API de usuarios y tareas. Incluye CRUD completo, validaciones sencillas, tests y documentación.

## Qué aporta

- Stack limpio con Spring Boot 3 y Java 21.
- Datos de ejemplo precargados al iniciar para explorar la API sin preparar nada.
- Pruebas end-to-end (`mvn clean verify`) que recorren controladores y servicios esenciales.

## Cómo ponerlo en marcha

```powershell
mvn clean verify
mvn spring-boot:run
```

Al terminar, la API responde en [localhost:8080](http://localhost:8080) y la documentación interactiva está disponible en [Swagger UI](http://localhost:8080/swagger-ui/index.html).

## Recorrido guiado con curl

Puedes probar los flujos con cualquier cliente HTTP. Si prefieres Postman u otra herramienta, sigue las mismas rutas y cuerpos JSON que verás a continuación.

1. Consultar los usuarios de muestra:

     ```bash
     curl http://localhost:8080/api/usuarios
     ```

2. Crear un usuario nuevo. Guarda el valor `id` que devuelva la respuesta.

     ```bash
     curl -X POST http://localhost:8080/api/usuarios \
         -H "Content-Type: application/json" \
         -d '{"nombre":"Ana","email":"ana@example.com"}'
     ```

3. Registrar una tarea para ese usuario. Sustituye `ID_USUARIO` por el identificador real.

     ```bash
     curl -X POST http://localhost:8080/api/tareas \
         -H "Content-Type: application/json" \
         -d '{"descripcion":"Preparar demo","usuarioId":ID_USUARIO}'
     ```

4. Marcar la tarea como completada. Cambia `ID_TAREA` por el valor correcto.

     ```bash
     curl -X PATCH http://localhost:8080/api/tareas/ID_TAREA \
         -H "Content-Type: application/json" \
         -d '{"descripcion":"Preparar demo","completada":true}'
     ```

## Endpoints clave

| Método | Ruta               | Descripción                                  |
|--------|--------------------|----------------------------------------------|
| GET    | `/api/usuarios`    | Devuelve los usuarios con datos demo inicial |
| POST   | `/api/usuarios`    | Crea un usuario nuevo y valida el email      |
| GET    | `/api/tareas`      | Muestra las tareas registradas               |
| POST   | `/api/tareas`      | Registra una tarea vinculada a un usuario    |
| PATCH  | `/api/tareas/{id}` | Permite completar o renombrar una tarea      |

## Transparencia

Los datos ficticios de la demo se elaboraron con ayuda de IA como apoyo. Se revisaron manualmente para asegurar coherencia y dejar claro que no describen a personas reales.

## Licencia

MIT
