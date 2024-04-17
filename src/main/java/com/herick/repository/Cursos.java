package com.herick.repository;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.herick.model.Curso;


public class Cursos implements Serializable {

	public static final Logger log = Logger.getLogger(Cursos.class.getName());
	private static final long serialVersionUID = 1L;
	
	private EntityManager em;
	
	public Cursos() {
		this.em = Persistence.createEntityManagerFactory("codecraftPU").createEntityManager();
	}
	
	public Curso byId(Long id) {
		return em.find(Curso.class, id);
	}

	public void save(Curso curso) {
		em.persist(curso);
	}
	
	public void deleteById(Long id) {
		Curso curso = byId(id);
		em.remove(curso);
		log.info(String.format("Curso: %s. DELETADO!", curso.getNomeCurso()));
	}

}
