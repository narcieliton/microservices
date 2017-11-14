package com.narcielitonlopes.aluno.handler;


import com.narcielitonlopes.aluno.document.DetalhesErro;
import com.narcielitonlopes.aluno.service.exceptions.AlunoExistenteException;
import com.narcielitonlopes.aluno.service.exceptions.AlunoNaoEncontradoExcpetion;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalTime;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(AlunoNaoEncontradoExcpetion.class)
    public ResponseEntity<DetalhesErro> handlerAlunoNaoEncontrado(AlunoNaoEncontradoExcpetion e,
                                                                  HttpServletRequest request){

        DetalhesErro erro = new DetalhesErro();

        erro.setStatus(404L);
        erro.setTitulo("Aluno não encontrado");
        erro.setTimestamp(LocalTime.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
    
    @ExceptionHandler(AlunoExistenteException.class)
    public ResponseEntity<DetalhesErro> handlerAlunoExistente(AlunoExistenteException e,
                                                                  HttpServletRequest request){

        DetalhesErro erro = new DetalhesErro();

        erro.setStatus(409l);
        erro.setTitulo("Aluno já existente");
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
