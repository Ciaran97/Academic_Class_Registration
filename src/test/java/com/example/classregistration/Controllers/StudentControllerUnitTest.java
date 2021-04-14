package com.example.classregistration.Controllers;

import com.example.classregistration.Models.Student;
import com.example.classregistration.Services.ProfessorService;
import com.example.classregistration.Services.StudentService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
class StudentControllerUnitTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StudentService studentService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createStudent() throws Exception{

        Student mockStudent = new Student("TestStudent", "TestSurname", new Date(1997, Calendar.SEPTEMBER, 25));

        mvc.perform(post("/api/v1/students").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(mockStudent))).andExpect(status().isOk());


    }

    @Test
    void getAllStudents() throws Exception{

        //testing that aa JSON object is returned with a status of OK or 200
        MvcResult result = mvc.perform(get("/api/v1/students")).andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andReturn();
        System.out.println(result.getResponse().getContentAsString());


    }

    @Test
    void getStudentById() throws Exception{

        //testing that aa JSON object is returned with a status of OK or 200
        MvcResult result = mvc.perform(get("/api/v1/students/2")).andExpect(status().isOk()).andReturn();
        System.out.println(result.getResponse().getContentAsString());

    }

    @Test
    void addCourseToStudent() throws Exception{

        //testing that aa JSON object is returned with a status of OK or 200
        MvcResult result = mvc.perform(post("/api/v1/students/2/11")).andExpect(status().isOk()).andReturn();
        System.out.println(result.getResponse().getContentAsString());

    }
}