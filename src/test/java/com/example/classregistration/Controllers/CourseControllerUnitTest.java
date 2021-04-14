package com.example.classregistration.Controllers;

import com.example.classregistration.Models.Course;
import com.example.classregistration.Models.Professor;
import com.example.classregistration.Services.CourseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CourseController.class)
class CourseControllerUnitTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CourseService courseService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createCourse() throws Exception {

        Professor mockProfessor = new Professor("Tendekayi", "Shibusiso", new Date(1985, 01, 25));

        Course mockCourse = new Course("Test Name", "TEST123");

        mockCourse.setProfessor(mockProfessor);

        mvc.perform(post("/api/v1/courses").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(mockCourse))).andExpect(status().isOk());

    }

    @Test
    void createCourseById() throws Exception{

        Course mockCourse = new Course("Test Name With ProfessorId", "TEST123");

        mvc.perform(post("/api/v1/courses/8").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(mockCourse))).andExpect(status().isOk());

    }

    @Test
    void getAllCourses() throws Exception {

        //testing that aa JSON object is returned with a status of OK or 200
       MvcResult result = mvc.perform(get("/api/v1/courses")).andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    void getCourseById() throws Exception{

        //testing that a JSON object is returned with a status of OK or 200
        MvcResult result = mvc.perform(get("/api/v1/courses/20")).andDo(print()).andExpect(status().isOk()).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }
}