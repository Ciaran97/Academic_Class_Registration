package com.example.classregistration.Models;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Students")
public class Student {
    public Student(String name, String surname, Date date_Of_Birth) {
        Name = name;
        Surname = surname;
        Date_Of_Birth = date_Of_Birth;
    }

    public Student() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Surname")
    private String Surname;

    @Column(name = "Date_Of_Birth")
    private Date Date_Of_Birth;



    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public Date getDate_Of_Birth() {
        return Date_Of_Birth;
    }

    public void setDate_Of_Birth(Date date_Of_Birth) {
        Date_Of_Birth = date_Of_Birth;
    }

    @Override
    public String toString() {
        return "Student [id=" + Id + ", Name=" + Name + ", Surname=" + Surname + ", Date Of Birth=" + Date_Of_Birth
                + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(Id, student.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }

}
