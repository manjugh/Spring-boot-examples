package com.boot.webmvc.examples;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringJUnitWebConfig(Appliaction.class)
public class ApplicationTestJunit5 {

    @Autowired
    WebApplicationContext webApplicationContext;

    @Test
    void testController() throws Exception {
        final MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(get("/sample/")).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.view().name("sample"));
    }
}
