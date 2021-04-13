package com.example.classregistration.Models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Professors")
public class Professor {


    private Integer Id;

    @Column(name = "Name", nullable = false)
    private String Name;

    @Column(name = "Surname", nullable = false)
    private String Surname;

    public Date getDate_Of_Birth() {
        return date_Of_Birth;
    }

    public void setDate_Of_Birth(Date date_Of_Birth) {
        this.date_Of_Birth = date_Of_Birth;
    }

    @Column(name = "date_of_birth", nullable = false)
    private Date date_Of_Birth;

    public Professor(String Name, String Surname, Date date_Of_Birth){
        super();

        this.Name = Name;
        this.Surname = Surname;
        this.date_Of_Birth = date_Of_Birth;
    }

    public Professor(){
    super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Override
    public String toString() {
        return "Professor [id=" + Id + ", Name=" + Name + ", Surname=" + Surname + ", date_of_birth=" + date_Of_Birth
                + "]";
    }
}
