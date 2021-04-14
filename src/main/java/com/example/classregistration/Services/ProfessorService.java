package com.example.classregistration.Services;

import com.example.classregistration.Models.Professor;
import com.example.classregistration.Repositories.ProfessorRepository;
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
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public Professor createProfessor(Professor professor) {
        //create a new professor with the data in the body
        return professorRepository.save(professor);
    }


    public List<Professor> getAllProfessors(){
        //return all professors in a list
        return professorRepository.findAll();
    }


    public ResponseEntity<Professor> getProfessorById(Integer professorId) throws ResourceNotFoundException {
        //find professor using given id and trow a resource not found exception if no professor with the given id is found
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new ResourceNotFoundException("Professor not found for this id :: " + professorId));
        return ResponseEntity.ok().body(professor);
    }

}
