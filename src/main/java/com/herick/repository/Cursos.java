package com.herick.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.herick.model.Curso;


public class Cursos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager em;
	
	public Cursos() {
		this.em = Persistence.createEntityManagerFactory("codecraftPU").createEntityManager();
	}
	
	public Curso cursoPorId(Long id) {
		return em.find(Curso.class, id);
	}
	
	public void removerCurso(Curso curso) {
		curso = cursoPorId(curso.getId());
		em.remove(curso);
	}

}
