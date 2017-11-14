package com.narcielitonlopes.professor.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.narcielitonlopes.professor.document.Professor;
import com.narcielitonlopes.professor.service.ProfessoresServiceImpl;

@RestController
@RequestMapping(path = "professores")
public class ProfessorController {


    @Autowired
    ProfessoresServiceImpl professoresService;

    @GetMapping//({MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Professor>> listarTodos(){
    	return ResponseEntity.status(HttpStatus.OK).body(professoresService.listarTodos());
    }

    @GetMapping(path = {"/{id}"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Professor> consultarPorId(@PathVariable("id") String id){
        return ResponseEntity.status(HttpStatus.OK).body(professoresService.consultarPorId(id));
    }
    
    @PostMapping
    public ResponseEntity<Professor> cadastrar(@Valid @RequestBody Professor professor) {
    	return ResponseEntity.status(HttpStatus.CREATED).body(professoresService.cadastrar(professor));
    }
    
    @PutMapping
    public ResponseEntity<Professor> atualizar(@Valid @RequestBody Professor professor) {
    	return ResponseEntity.status(HttpStatus.OK).body(professoresService.atualizar(professor));
    }
    
    @DeleteMapping(path = "/{id}")
    public void deletar(@RequestBody Professor professor){
    	this.professoresService.remover(professor.getId());
    }

}
