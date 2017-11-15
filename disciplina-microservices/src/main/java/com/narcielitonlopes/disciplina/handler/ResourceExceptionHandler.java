package com.narcielitonlopes.disciplina.handler;


import com.narcielitonlopes.disciplina.document.DetalhesErro;
import com.narcielitonlopes.disciplina.service.exceptions.DisciplinaExistenteException;
import com.narcielitonlopes.disciplina.service.exceptions.DisciplinaNaoEncontradoExcpetion;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalTime;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(DisciplinaNaoEncontradoExcpetion.class)
    public ResponseEntity<DetalhesErro> handlerDisciplinaNaoEncontrado(DisciplinaNaoEncontradoExcpetion e,
                                                                  HttpServletRequest request){

        DetalhesErro erro = new DetalhesErro();

        erro.setStatus(404L);
        erro.setTitulo("Disciplina não encontrado");
        erro.setTimestamp(LocalTime.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
    
    @ExceptionHandler(DisciplinaExistenteException.class)
    public ResponseEntity<DetalhesErro> handlerDisciplinaExistente(DisciplinaExistenteException e,
                                                                  HttpServletRequest request){

        DetalhesErro erro = new DetalhesErro();

        erro.setStatus(409l);
        erro.setTitulo("Disciplina já existente");
        erro.setTimestamp(LocalTime.now());
       
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }
    
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<DetalhesErro> handlerDataIntegrityViolationExcpetion
    (DataIntegrityViolationException e, HttpServletRequest request){
    	
    	DetalhesErro erro = new DetalhesErro();
    	
    	erro.setStatus(400l);
    	erro.setTitulo("Requisição inválida, verifique os dados");
    	erro.setTimestamp(LocalTime.now());
    	
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}
