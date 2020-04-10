package com.boot.webmvc.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// This is configured to run using normal spring way
@WebAppConfiguration
@ContextConfiguration(classes = Appliaction.class)
@ExtendWith(SpringExtension.class)
class AppliactionTest {

    @Autowired
    WebApplicationContext applicationContext;

    @Test
    public void testController() throws Exception {

        final MockMvc build = MockMvcBuilders.webAppContextSetup(applicationContext).build();
        build.perform(get("/sample/")).andExpect(status().isOk());
    }
}