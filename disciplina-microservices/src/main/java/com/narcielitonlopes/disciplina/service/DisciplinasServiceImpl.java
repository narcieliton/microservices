package com.narcielitonlopes.disciplina.service;

import com.mongodb.Mongo;
import com.narcielitonlopes.disciplina.document.Disciplina;
import com.narcielitonlopes.disciplina.repositories.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinasServiceImpl implements DisciplinaService {

	@Autowired
	private DisciplinaRepository repository;

	@Override
	public List<Disciplina> listarTodos() {
		return repository.findAll();
	}

	@Override
	public Disciplina consultarPorId(String id) {
		return repository.findOne(id);
	}

	@Override
	public Disciplina cadastrar(Disciplina disciplina) {
		return repository.save(disciplina);
	}

	@Override
	public Disciplina atualizar(Disciplina disciplina) {
		return repository.save(disciplina);
	}

	@Override
	public void remover(String id) {
		repository.delete(id);
	}


	@Override
	public Disciplina vincularProfessor(Disciplina disciplina, String idProfessor) {

		disciplina.setIdProfessor(idProfessor);
		return repository.save(disciplina);
	}

	@Override
	public Disciplina consultarPorProfessor(String idProfessor) {

		MongoOperations mongoOps = new MongoTemplate(new  SimpleMongoDbFactory(new Mongo(), "disciplina"));
		return  mongoOps.findOne(Query.query(Criteria.where("idProfessor").is(idProfessor)), Disciplina.class);
	}


}
