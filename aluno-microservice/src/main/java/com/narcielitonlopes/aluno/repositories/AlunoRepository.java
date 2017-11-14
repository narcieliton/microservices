package com.narcielitonlopes.aluno.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.narcielitonlopes.aluno.document.Aluno;

public interface AlunoRepository extends MongoRepository<Aluno, String> {

}
