package com.herick.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.herick.model.Aluno;

public class Alunos implements Serializable {

	private static final long serialVersionUID = 1L;

	public Alunos(EntityManager manager) {
//		this.em = manager;
	}

	public Aluno alunoPorId(Long id) {
		EntityManager em = Persistence.createEntityManagerFactory("codecraftPU").createEntityManager();
		return em.find(Aluno.class, id);
	}
	
	public void removerAluno(Aluno aluno) {
		aluno = alunoPorId(aluno.getId());
//		em.remove(aluno);
	}
	
}
