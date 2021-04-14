package com.example.classregistration.Models;

import com.example.classregistration.Controllers.ProfessorController;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Courses")
public class Course {


    public Course(String courseName, String courseCode) {
        CourseName = courseName;
        CourseCode = courseCode;
    }

    public Course(){

    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getCourseCode() {
        return CourseCode;
    }

    public void setCourseCode(String courseCode) {
        CourseCode = courseCode;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "Course_Name")
    private String CourseName;

    @Column(name = "Course_Code")
    private String CourseCode;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "Professor_Id", referencedColumnName = "Id")
    private Professor professor;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "StudentCourses", joinColumns = @JoinColumn(name = "Course_Id", referencedColumnName = "Id"), inverseJoinColumns = @JoinColumn(name = "Student_Id", referencedColumnName = "Id"))
    private List<Student> students = new ArrayList<>();


    @Override
    public String toString() {
        return "Course [id=" + Id + ", Name=" + CourseName + ", Code=" + CourseCode + ", professor=" + professor
                + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(Id, course.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
