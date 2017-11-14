package com.narcielitonlopes.professor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narcielitonlopes.professor.document.Professor;
import com.narcielitonlopes.professor.repositories.ProfessorRepository;

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
		return repository.findOne(id);
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
}
