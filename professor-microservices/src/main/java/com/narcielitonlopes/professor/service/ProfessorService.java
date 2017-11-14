package com.narcielitonlopes.professor.service;

import java.util.List;

import com.narcielitonlopes.professor.document.Professor;

public interface ProfessorService {

	List<Professor> listarTodos();

	Professor consultarPorId(String id);

	Professor cadastrar(Professor aluno);

	Professor atualizar(Professor aluno);

	void remover(String id);
}
