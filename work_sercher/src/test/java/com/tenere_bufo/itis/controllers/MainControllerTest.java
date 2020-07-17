package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.config.SpringSecurityWebAuxTestConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = SpringSecurityWebAuxTestConfig.class
)
@AutoConfigureMockMvc
class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithUserDetails("user@company.com")
    void getElements() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/elements")
                .accept(MediaType.ALL))
                .andExpect(status().isOk());
    }

    @Test
    @WithUserDetails("user@company.com")
    void getBlog() throws Exception {
        this.mockMvc.perform(get("/blog"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @WithUserDetails("user@company.com")
    void getSingleBlog() throws Exception {
        this.mockMvc.perform(get("/single_blog"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}