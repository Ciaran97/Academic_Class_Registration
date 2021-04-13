package com.example.classregistration.Controllers;

import com.example.classregistration.Models.Course;
import com.example.classregistration.Repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course course){
        //create a new course with the data in the body
        return courseRepository.save(course);

    }

}
