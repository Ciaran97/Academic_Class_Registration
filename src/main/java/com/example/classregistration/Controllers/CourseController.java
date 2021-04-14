package com.example.classregistration.Controllers;

import com.example.classregistration.Models.Course;
import com.example.classregistration.Models.Professor;
import com.example.classregistration.Repositories.CourseRepository;
import com.example.classregistration.Repositories.ProfessorRepository;
import com.example.classregistration.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CourseController {

    private final CourseService courseService;


   public CourseController(CourseService courseservice){
       this.courseService = courseservice;
   }



    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course course){
        //create a new course with the data in the body
        return courseService.createCourse(course);
    }

    @PostMapping("/courses/{id}")
    public Course createCourseById(@RequestBody Course course, @PathVariable(value = "id") Integer id){
        //create a new course with the data in the body

        return courseService.createCourseByProfId(course, id);
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable(value = "id") Integer id){

        return courseService.getCourseById(id);
    }

}
