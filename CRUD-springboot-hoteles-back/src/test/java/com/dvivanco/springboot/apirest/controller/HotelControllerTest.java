package com.dvivanco.springboot.apirest.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetHotelEndPointIsOk() throws Exception {
        this.mockMvc.perform(get("/api/hoteles/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"nombre\":\"Hotel test 1\",\"tipo\":\"Hotel 5 estrellas\",\"cadena\":\"Grupotel\",\"zona\":\"Palma de Mallorca\",\"codigoficina\":\"HPI\",\"activo\":\"S\"}"));
    }

    @Test
    public void testGetAllHotelsEndPintIsOk() throws Exception {
        this.mockMvc.perform(get("/api/hoteles"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].nombre").isNotEmpty());
    }

    @Test
    public void testGetHotelByIdApi() throws Exception {
        this.mockMvc.perform(get("/api/hoteles/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }
}