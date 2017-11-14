package com.narcielitonlopes.aluno.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class Aluno{

	@Id
	private String id;
    private String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;
    private String email;

    public String getId() {
    	return id;
    }
    
    public void setId(String id) {
    	this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
    	return dataNascimento;
    }
    
    public void setDataNascimento(Date dataNascimento) {
    	this.dataNascimento = dataNascimento;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
