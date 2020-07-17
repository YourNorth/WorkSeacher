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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = SpringSecurityWebAuxTestConfig.class
)
@AutoConfigureMockMvc
class AdminCompanyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithUserDetails("admin@company.com")
    void getCompany() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/comp/5")
                .accept(MediaType.ALL))
                .andExpect(status().isOk());
    }

    @Test
    @WithUserDetails("admin@company.com")
    void getCompanies() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/comp/all")
                .accept(MediaType.ALL))
                .andExpect(status().isOk());
    }

    @Test
    void addCompany() throws Exception {
    }

    @Test
    void deleteCompany() {
    }
}