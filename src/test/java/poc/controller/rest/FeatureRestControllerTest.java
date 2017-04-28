package poc.controller.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import poc.BaseTest;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by mcalavera81 on 09/04/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
//@Sql
@Transactional
public class FeatureRestControllerTest extends BaseTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @Before
    public void setup() throws Exception {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .build();
    }


    @Test
    @WithMockUser
    public void testFeatureApiFormat() throws Exception {

        mockMvc.perform(get("/rest/feature"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(5)))
                .andExpect(jsonPath("$[0]").value(hasKey("id")))
                .andExpect(jsonPath("$[0]").value(hasKey("name")))
                .andExpect(jsonPath("$[0]").value(hasKey("value")))
                .andExpect(jsonPath("$[0]").value(hasKey("container")))
                .andExpect(jsonPath("$[0].container").value(hasKey("id")))
                .andExpect(jsonPath("$[0].container").value(hasKey("name")))
                .andExpect(jsonPath("$[*].id", containsInAnyOrder(5, 4, 3, 2, 1)))
                .andExpect(jsonPath("$[*].container.id", hasItems(1, 3)))
                .andExpect(jsonPath("$[*].container.name", hasItems("paco", "manuel")))
        ;

    }

    @Test
    @WithMockUser
    public void testFilteredFeatureNoResults() throws Exception {
        mockMvc.perform(get("/rest/feature").param("filter", ""))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(0)))
        ;
    }

    @Test
    @WithMockUser
    public void testFilteredFeatureSomeResults() throws Exception {
        mockMvc.perform(get("/rest/feature").param("filter", "azul"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[*].id", containsInAnyOrder(1, 3, 4)))
        ;
    }

    @Test
    @WithMockUser(username = "", roles = {"ADMIN"})
    public void testDeleteFeature() throws Exception {
        long id = 1L;
        mockMvc.perform(delete("/rest/feature/{id}", id))
                .andExpect(status().isOk());
    }

}