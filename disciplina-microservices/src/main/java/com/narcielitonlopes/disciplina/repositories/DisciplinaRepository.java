package com.narcielitonlopes.disciplina.repositories;

import org.bson.conversions.Bson;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.narcielitonlopes.disciplina.document.Disciplina;

public interface DisciplinaRepository extends MongoRepository<Disciplina, String> {
}
