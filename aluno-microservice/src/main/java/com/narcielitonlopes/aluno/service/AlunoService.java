package com.narcielitonlopes.aluno.service;

import java.util.List;

import com.narcielitonlopes.aluno.document.Aluno;

public interface AlunoService {

	List<Aluno> listarTodos();

	Aluno consultarPorId(String id);

	Aluno cadastrar(Aluno aluno);

	Aluno atualizar(Aluno aluno);

	void remover(String id);
}
