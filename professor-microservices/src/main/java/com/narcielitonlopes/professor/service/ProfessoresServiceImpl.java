
package com.narcielitonlopes.professor.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.narcielitonlopes.professor.document.Disciplina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.narcielitonlopes.professor.document.Professor;
import com.narcielitonlopes.professor.repositories.ProfessorRepository;
import org.springframework.web.client.RestTemplate;

@Service
public class ProfessoresServiceImpl implements ProfessorService {

	@Autowired
	private ProfessorRepository repository;
	
	@Override
	public List<Professor> listarTodos() {
		return repository.findAll();
	}

	@Override
	public Professor consultarPorId(String id) {
		Professor professor = repository.findOne(id);

		ResponseEntity<Object> disciplina = disciplinaVinculadaProfessor(id);

		return professor;
	}

	@Override
	public Professor cadastrar(Professor aluno) {
		return repository.save(aluno);
	}

	@Override
	public Professor atualizar(Professor aluno) {
		return repository.save(aluno);
	}

	@Override
	public void remover(String id) {
		repository.delete(id);
	}


	private ResponseEntity<Object> disciplinaVinculadaProfessor(String idProfessor){
		RestTemplate restTemplate = new RestTemplate();

		RequestEntity<Void> requestEntity = RequestEntity.get(URI.create("http://localhost:8082/disciplinas/consultarPorProfessor/"+ idProfessor)).build();

        return ResponseEntity.status(HttpStatus.OK).body(restTemplate.exchange(requestEntity, Object.class));

	}

}
