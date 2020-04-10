package com.boot.webmvc.examples;

import com.boot.webmvc.examples.controller.SampleController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
public class ApplicationStandAloneTest {

    @Test
    void testController() throws Exception {
        final MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new SampleController()).build();
        mockMvc.perform(get("/sample/")).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.view().name("sample"));
    }
}
