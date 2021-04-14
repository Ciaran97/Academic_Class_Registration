package com.example.classregistration.Models;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Professors")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "Name", nullable = false)
    private String Name;

    @Column(name = "Surname", nullable = false)
    private String Surname;

    @Column(name = "date_of_birth", nullable = false)
    private Date date_Of_Birth;

 //   @OneToMany(mappedBy = "professor", fetch = FetchType.EAGER)
   // private List<Course> courses;


    public Professor(String name, String surname, Date date_Of_Birth) {
        Name = name;
        Surname = surname;
        this.date_Of_Birth = date_Of_Birth;
    }

    public Professor(){
    super();
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
        return date_Of_Birth;
    }

    public void setDate_Of_Birth(Date date_Of_Birth) {
        this.date_Of_Birth = date_Of_Birth;
    }

  //  public List<Course> getCourses() {
   //     return courses;
   // }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "Professor [id=" + Id + ", Name=" + Name + ", Surname=" + Surname + ", date_of_birth=" + date_Of_Birth
                + "]";
    }
}
