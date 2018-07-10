package com.web.clients.demoserver;

import com.web.clients.demoserver.db.model.Person;
import com.web.clients.demoserver.db.repository.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class DemoserverApplicationTests {

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private PersonRepository repository;

    @Before
    public void init() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
        repository.save(new Person().setUsername("name")
        .setMail("email")
        .setAge(41)
        .setRating(0));
    }

    @Test
    public void contextLoads() throws Exception {
        mockMvc.perform(get("/person/all/"))
                .andExpect(status().isOk());
    }

}
