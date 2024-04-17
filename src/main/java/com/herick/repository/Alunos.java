package com.herick.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.herick.model.Aluno;

public class Alunos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager em;

	public Alunos() {
		this.em = Persistence.createEntityManagerFactory("codecraftPU").createEntityManager();
	}

	public Aluno alunoPorId(Long id) {
		return em.find(Aluno.class, id);
	}
	
	public void removerAluno(Aluno aluno) {
		aluno = alunoPorId(aluno.getId());
//		em.remove(aluno);
	}
	
	public List<Aluno> todosOsAlunos() {
		return em.createNativeQuery("SELECT * FROM alunos", Aluno.class).getResultList();
		
	}
	
}
