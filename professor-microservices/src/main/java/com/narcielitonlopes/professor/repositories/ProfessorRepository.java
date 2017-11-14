package com.narcielitonlopes.professor.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.narcielitonlopes.professor.document.Professor;

public interface ProfessorRepository extends MongoRepository<Professor, String> {

}
