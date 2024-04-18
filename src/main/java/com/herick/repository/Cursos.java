package com.herick.repository;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.herick.model.Curso;
import com.herick.util.Transacional;


public class Cursos implements Serializable {

	public static final Logger log = Logger.getLogger(Cursos.class.getName());
	private static final long serialVersionUID = 1L;
	private EntityManager em;
	
	public Cursos() {
		this.em = Persistence.createEntityManagerFactory("codecraftPU").createEntityManager();
	}
	
	@Transacional
	public Curso byId(Long id) {
		return em.find(Curso.class, id);
	}

	@Transacional
	public void save(Curso curso) {
		em.persist(curso);
	}
	
	@Transacional
	public void deleteById(Long id) {
		Curso curso = byId(id);
		em.remove(curso);
		log.info(String.format("Curso: %s. DELETADO!", curso.getNomeCurso()));
	}
	
	@Transacional
    public List<Curso> todosOsCursos() {
        TypedQuery<Curso> query = em.createQuery("SELECT c FROM Curso c", Curso.class);
        return query.getResultList();
    }

}
