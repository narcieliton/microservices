package com.narcielitonlopes.professor.handler;

import java.time.LocalTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.narcielitonlopes.professor.document.DetalhesErro;
import com.narcielitonlopes.professor.service.exceptions.ProfessorExistenteException;
import com.narcielitonlopes.professor.service.exceptions.ProfessorNaoEncontradoExcpetion;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ProfessorNaoEncontradoExcpetion.class)
    public ResponseEntity<DetalhesErro> handlerAlunoNaoEncontrado(ProfessorNaoEncontradoExcpetion e,
                                                                  HttpServletRequest request){

        DetalhesErro erro = new DetalhesErro();

        erro.setStatus(404L);
        erro.setTitulo("Professor não encontrado");
        erro.setTimestamp(LocalTime.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
    
    @ExceptionHandler(ProfessorExistenteException.class)
    public ResponseEntity<DetalhesErro> handlerAlunoExistente(ProfessorExistenteException e,
                                                                  HttpServletRequest request){

        DetalhesErro erro = new DetalhesErro();

        erro.setStatus(409l);
        erro.setTitulo("Professor já existente");
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
