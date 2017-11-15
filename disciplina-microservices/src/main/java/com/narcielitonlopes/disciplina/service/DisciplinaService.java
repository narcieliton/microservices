package com.narcielitonlopes.disciplina.service;

import java.util.List;

import com.narcielitonlopes.disciplina.document.Disciplina;

public interface DisciplinaService {

	List<Disciplina> listarTodos();

	Disciplina consultarPorId(String id);

	Disciplina cadastrar(Disciplina disciplina);

	Disciplina atualizar(Disciplina disciplina);

	void remover(String id);

    Disciplina vincularProfessor(Disciplina disciplina, String idProfessor);

    Disciplina consultarPorProfessor(String idProfessor);
}
