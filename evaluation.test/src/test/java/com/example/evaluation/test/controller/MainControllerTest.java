package com.example.evaluation.test.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@WebMvcTest(MainController.class)
public class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void test_game_pierr_feuille_ciseaux() throws Exception {

        String action = "pierre";

        MvcResult result = mockMvc.perform( get("/game/play/" + action))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();

        assertEquals("victoire", content);
        // retourner si victoire



    }

    @Test
    public void testGetScore()  throws Exception {

        int victoire = 2;
        int defaite = 3;
        int tie = 0;

        MvcResult result = mockMvc.perform( get("/game/score"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();

        assertEquals("victoire : " + victoire + "| défaite : " + defaite + "| égalité : " + tie, content);

    }
}
