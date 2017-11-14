package com.narcielitonlopes.aluno.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narcielitonlopes.aluno.document.Aluno;
import com.narcielitonlopes.aluno.repositories.AlunoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlunosServiceImpl implements AlunoService {

	@Autowired
	private AlunoRepository repository;
	
	@Override
	public List<Aluno> listarTodos() {
		return repository.findAll();
	}

	@Override
	public Aluno consultarPorId(String id) {
		return repository.findOne(id);
	}

	@Override
	public Aluno cadastrar(Aluno aluno) {
		return repository.save(aluno);
	}

	@Override
	public Aluno atualizar(Aluno aluno) {
		return repository.save(aluno);
	}

	@Override
	public void remover(String id) {
		repository.delete(id);
	}
}
