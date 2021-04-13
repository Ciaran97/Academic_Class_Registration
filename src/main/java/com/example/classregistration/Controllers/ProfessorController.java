package com.example.classregistration.Controllers;


import com.example.classregistration.Models.Professor;
import com.example.classregistration.Repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;



    @PostMapping("/professors")
    public Professor createProfessor(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }

    @GetMapping("/professors")
    public List<Professor> getAllProfessors(){
        return professorRepository.findAll();
    }

    @GetMapping("/professors/{id}")
    public ResponseEntity<Professor> getEmployeeById(@PathVariable(value = "id") Integer professorId) throws ResourceNotFoundException {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new ResourceNotFoundException("Professor not found for this id :: " + professorId));
        return ResponseEntity.ok().body(professor);
    }
}