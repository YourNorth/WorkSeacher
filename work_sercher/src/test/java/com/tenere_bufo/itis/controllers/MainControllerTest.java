package com.tenere_bufo.itis.controllers;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getElements() throws Exception {
        this.mockMvc.perform(get("/elements"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }

    @Test
    void getBlog() throws Exception {
        this.mockMvc.perform(get("/blog"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }

    @Test
    void getSingleBlog() throws Exception {
        this.mockMvc.perform(get("/single_blog"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }
}