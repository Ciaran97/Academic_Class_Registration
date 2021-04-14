package com.example.classregistration.Services;

import com.example.classregistration.Models.Course;
import com.example.classregistration.Models.Professor;
import com.example.classregistration.Repositories.CourseRepository;
import com.example.classregistration.Repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    public Course createCourse(Course course){
        return courseRepository.save(course);
    }

    public Course createCourseByProfId(Course course, Integer professorId){
        Professor professor = professorRepository.findById(professorId).orElseThrow();
        course.setProfessor(professor);
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public ResponseEntity<Course> getCourseById(Integer id){
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Professor not found for this id :: " + id));
        return ResponseEntity.ok().body(course);
    }

}
