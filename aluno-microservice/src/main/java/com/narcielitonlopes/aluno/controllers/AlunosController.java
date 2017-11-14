package com.narcielitonlopes.aluno.controllers;

import com.narcielitonlopes.aluno.document.Aluno;
import com.narcielitonlopes.aluno.service.AlunosServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "alunos")
public class AlunosController {


    @Autowired
    AlunosServiceImpl alunosService;

    @GetMapping//({MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Aluno>> listarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(alunosService.listarTodos());
    }

    @GetMapping(path = {"/{id}"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Aluno> consultarPorId(@PathVariable("id") String id){
        return ResponseEntity.status(HttpStatus.OK).body(alunosService.consultarPorId(id));
    }
    
    @PostMapping
    public ResponseEntity<Aluno> cadastrar(@Valid @RequestBody Aluno aluno) {
    	return ResponseEntity.status(HttpStatus.CREATED).body(alunosService.cadastrar(aluno));
    }
    
    @PutMapping
    public ResponseEntity<Aluno> atualizar(@Valid @RequestBody Aluno aluno) {
    	return ResponseEntity.status(HttpStatus.OK).body(alunosService.atualizar(aluno));
    }
    
    @DeleteMapping
    public void deletar(@RequestBody Aluno aluno){
    	this.alunosService.remover(aluno.getId());
    }

}
