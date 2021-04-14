package com.example.classregistration.Services;

import com.example.classregistration.Models.Course;
import com.example.classregistration.Models.Student;
import com.example.classregistration.Repositories.CourseRepository;
import com.example.classregistration.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;



    public Student createStudent(Student student) {
        //create a new professor with the data in the body
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents(){

        return studentRepository.findAll();
    }

    public ResponseEntity<Student> getStudentById(Integer id){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Professor not found for this id :: " + id));
        return ResponseEntity.ok().body(student);
    }


    public Student addCourseToStudent(Integer studentId, Integer courseId){
        Student student = studentRepository.findById(studentId).orElseThrow();
        Course course = courseRepository.findById(courseId).orElseThrow();

        course.addStudent(student);

        courseRepository.save(course);
        return student;
    }

}
