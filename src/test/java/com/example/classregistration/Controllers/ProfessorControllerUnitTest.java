package com.example.classregistration.Controllers;

import com.example.classregistration.Models.Professor;
import com.example.classregistration.Services.CourseService;
import com.example.classregistration.Services.ProfessorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProfessorController.class)
class ProfessorControllerUnitTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProfessorService professorService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createProfessor() throws Exception{

        Professor mockProfessor = new Professor("Bob", "Builder", new Date(1985, Calendar.AUGUST, 25));

        mvc.perform(post("/api/v1/professors").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(mockProfessor))).andExpect(status().isOk());


    }

    @Test
    void getAllProfessors() throws Exception{

        //testing that aa JSON object is returned with a status of OK or 200
        MvcResult result = mvc.perform(get("/api/v1/professors")).andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andReturn();
        System.out.println(result.getResponse().getContentAsString());

    }

    @Test
    void getProfessorById() throws Exception{

        MvcResult result = mvc.perform(get("/api/v1/professors/23")).andDo(print()).andExpect(status().isOk()).andReturn();
        System.out.println(result.getResponse().getContentAsString());

    }
}