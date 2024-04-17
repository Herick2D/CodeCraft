package com.herick.repository;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.herick.model.Professor;

public class Professores implements Serializable {

	public static final Logger log = Logger.getLogger(Professores.class.getName());
	private static final long serialVersionUID = 1L;
	
	private EntityManager em;
	
	public Professores() {
		this.em = Persistence.createEntityManagerFactory("codecraftPU").createEntityManager();
	}

	public Professor byId(Long id) {
		return em.find(Professor.class, id);
	}

	public void save(Professor professor) {
		em.persist(professor);
	}

	public void deleteById(Long id) {
		Professor professor = byId(id);
		em.remove(professor);
		log.info(String.format("Professor: %s. DELETADO!", professor.getNomeProfessor()));
	}

}
