package com.herick.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.herick.model.Aluno;

public class Alunos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Alunos(EntityManager manager) {
		this.manager = manager;
	}

	public Aluno alunoPorId(Long id) {
		return manager.find(Aluno.class, id);
	}
	
	public void removerAluno(Aluno aluno) {
		aluno = alunoPorId(aluno.getId());
		manager.remove(aluno);
	}
	
}
