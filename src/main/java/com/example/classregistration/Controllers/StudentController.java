package com.example.classregistration.Controllers;

import com.example.classregistration.Models.Course;
import com.example.classregistration.Models.Student;
import com.example.classregistration.Repositories.CourseRepository;
import com.example.classregistration.Repositories.StudentRepository;
import com.example.classregistration.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    private final StudentService studentService;

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        //create a new professor with the data in the body
        return studentService.createStudent(student);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Integer id){
        return studentService.getStudentById(id);
    }


    @PostMapping("/students/{studentId}/{courseId}")
    public Student addCourseToStudent(@PathVariable(value = "studentId") Integer studentId, @PathVariable(value = "courseId") Integer courseId){

        return studentService.addCourseToStudent(studentId, courseId);

    }
}
