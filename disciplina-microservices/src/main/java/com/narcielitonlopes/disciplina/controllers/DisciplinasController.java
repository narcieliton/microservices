package com.narcielitonlopes.disciplina.controllers;

import com.narcielitonlopes.disciplina.document.Disciplina;
import com.narcielitonlopes.disciplina.service.DisciplinasServiceImpl;

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
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "disciplinas")
public class DisciplinasController {


    @Autowired
    DisciplinasServiceImpl disciplinasService;

    @GetMapping
    public ResponseEntity<List<Disciplina>> listarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(disciplinasService.listarTodos());
    }

    @GetMapping(path = {"/{id}"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Disciplina> consultarPorId(@PathVariable("id") String id){
        return ResponseEntity.status(HttpStatus.OK).body(disciplinasService.consultarPorId(id));
    }
    
    @PostMapping
    public ResponseEntity<Disciplina> cadastrar(@Valid @RequestBody Disciplina disciplina) {
    	return ResponseEntity.status(HttpStatus.CREATED).body(disciplinasService.cadastrar(disciplina));
    }

    @PutMapping
    public ResponseEntity<Disciplina> atualizar(@Valid @RequestBody Disciplina disciplina) {
    	return ResponseEntity.status(HttpStatus.OK).body(disciplinasService.atualizar(disciplina));
    }
    
    @DeleteMapping
    public void deletar(@RequestBody Disciplina disciplina){
    	this.disciplinasService.remover(disciplina.getId());
    }

    @PostMapping(path = "/{idProfessor}")
    public ResponseEntity<Disciplina> vincularProfessor(@Valid @RequestBody Disciplina disciplina,
                                                        @PathVariable("idProfessor") String idProfessor){
        return ResponseEntity.status(HttpStatus.OK).body(disciplinasService.vincularProfessor(disciplina, idProfessor));
    }

    @GetMapping(path = "/consultarPorProfessor/{idProfessor}")
    public ResponseEntity<Disciplina> consultarPorProfessor(@PathVariable("idProfessor") String idProfessor){
        return ResponseEntity.status(HttpStatus.OK).body(disciplinasService.consultarPorProfessor(idProfessor));
    }

}
