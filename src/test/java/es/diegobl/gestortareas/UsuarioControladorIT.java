package es.diegobl.gestortareas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
class UsuarioControladorIT {

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void flujoBasicoUsuarios() throws Exception {
    mvc.perform(get("/api/usuarios"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].id").exists());

    String crearUsuarioJson = """
    {"nombre":"Nuevo","email":"nuevo@example.com"}
    """;

    JsonNode creado = objectMapper.readTree(
        mvc.perform(post("/api/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(crearUsuarioJson))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.nombre").value("Nuevo"))
            .andReturn()
            .getResponse()
            .getContentAsString());

    long id = creado.get("id").asLong();

    mvc.perform(get("/api/usuarios/" + id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.email").value("nuevo@example.com"));
    }
}
