package ttl.larku.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class StudentControllerMVCTest {

   @Autowired
   private MockMvc mockMvc;

   @Test
   public void testGetAllStudents() throws Exception {
      ResultActions actions = mockMvc.perform(get("/student")
            .accept(MediaType.APPLICATION_JSON));

      actions = actions.andExpect(status().isOk());
      actions = actions.andExpect(jsonPath("$", hasSize(greaterThan(0))));

      MvcResult result = actions.andReturn();
      var response = result.getResponse().getContentAsString();

      System.out.println("response: " + response);


   }
}
