package com.herick.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.herick.model.Professor;

public class Professores implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Professores() {
		
	}
	
	public Professores(EntityManager manager) {
		this.manager = manager;
	}
	
	public Professor professorPorId(Long id) {
		return manager.find(Professor.class, id);
	}
	
	public void removerProfessor(Professor professor) {
		professor = professorPorId(professor.getId());
		manager.remove(professor);
	}
	
}
