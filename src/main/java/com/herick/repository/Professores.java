package com.herick.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.herick.model.Professor;

public class Professores implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager em;
	
	public Professores() {
		this.em = Persistence.createEntityManagerFactory("codecraftPU").createEntityManager();
	}
	
	public Professores(EntityManager manager) {
		this.em = manager;
	}
	
	public Professor professorPorId(Long id) {
		return em.find(Professor.class, id);
	}
	
	public void removerProfessor(Professor professor) {
		professor = professorPorId(professor.getId());
		em.remove(professor);
	}
	
}
