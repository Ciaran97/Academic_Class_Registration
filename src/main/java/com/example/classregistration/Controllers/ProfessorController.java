package com.example.classregistration.Controllers;


import com.example.classregistration.Models.Professor;
import com.example.classregistration.Repositories.ProfessorRepository;
import com.example.classregistration.Services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class ProfessorController {

    @Autowired
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping("/professors")
    public Professor createProfessor(@RequestBody Professor professor) {
        //create a new professor with the data in the body
        return professorService.createProfessor(professor);
    }

    @GetMapping("/professors")
    public List<Professor> getAllProfessors(){
        //return all professors in a list

        return professorService.getAllProfessors();
    }

    @GetMapping("/professors/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable(value = "id") Integer professorId) throws ResourceNotFoundException {
        //find professor using given id and trow a resource not found exception if no professor with the given id is found

        return professorService.getProfessorById(professorId);
    }
}
