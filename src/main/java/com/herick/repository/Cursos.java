package com.herick.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.herick.model.Curso;


public class Cursos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Cursos() {
		
	}
	
	public Cursos(EntityManager manager) {
		this.manager = manager;
	}
	
	public Curso cursoPorId(Long id) {
		return manager.find(Curso.class, id);
	}
	
	public void removerCurso(Curso curso) {
		curso = cursoPorId(curso.getId());
		manager.remove(curso);
	}

}
