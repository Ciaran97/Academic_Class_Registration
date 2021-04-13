package com.example.classregistration.Models;

import com.example.classregistration.Controllers.ProfessorController;

import javax.persistence.*;

@Entity
@Table(name = "Courses")
public class Course {


    public Course(){
        super();
    }

    public Course(String course_Name, String course_Code, Professor professor) {
        super();
        CourseName = course_Name;
        CourseCode = course_Code;
        this.professor = professor;
    }



    private Integer Id;

    @Column(name = "Course_Name")
    private String CourseName;

    @Column(name = "Course_Code")
    private String CourseCode;

    private Professor professor;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Professor.class)
    @JoinColumn(name = "ProfessorId", nullable = true)
    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Course [id=" + Id + ", Name=" + CourseName + ", Code=" + CourseCode + ", professor=" + professor
                + "]";
    }
}
