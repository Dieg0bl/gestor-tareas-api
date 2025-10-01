package es.diegobl.gestortareas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
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
public class TareaControladorIT {

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void flujoBasicoTareas() throws Exception {
    mvc.perform(get("/api/tareas"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].id").exists());

    String crearJson = """
    {"titulo":"Tarea temporal","usuarioId":1}
    """;

    JsonNode creada = objectMapper.readTree(
        mvc.perform(post("/api/tareas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(crearJson))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.titulo").value("Tarea temporal"))
            .andReturn()
            .getResponse()
            .getContentAsString());

    long id = creada.get("id").asLong();

    String patchJson = """
    {"titulo":"Tarea actualizada","hecha":true}
    """;

    mvc.perform(patch("/api/tareas/" + id)
        .contentType(MediaType.APPLICATION_JSON)
        .content(patchJson))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.titulo").value("Tarea actualizada"))
        .andExpect(jsonPath("$.hecha").value(true));
    }
}
