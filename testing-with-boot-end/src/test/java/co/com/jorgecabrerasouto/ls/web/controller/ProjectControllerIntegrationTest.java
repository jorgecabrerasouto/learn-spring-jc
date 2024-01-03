package co.com.jorgecabrerasouto.ls.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

//@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT) //This loads the full Web Application Context
@WebMvcTest // This only loads the web layer
public class ProjectControllerIntegrationTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void whenProjectExists_thenGetSuccess() throws Exception {
        mockMvc.perform(get("/projects/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("testName"));
    }

}
