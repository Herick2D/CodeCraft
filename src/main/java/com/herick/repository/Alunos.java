package com.herick.repository;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.herick.model.Aluno;
import com.herick.util.Transacional;

public class Alunos implements Serializable {

	public static final Logger log = Logger.getLogger(Alunos.class.getName());
	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public Alunos() {
		this.em = Persistence.createEntityManagerFactory("codecraftPU").createEntityManager();
	}

	@Transacional
	public void save(Aluno aluno) {
		em.persist(aluno);
	}

	@Transacional
	public Aluno byId(Long id) {
		return em.find(Aluno.class, id);
	}
	
	@Transacional
	public void deleteById(Long id) {
		Aluno aluno = byId(id);
		em.remove(aluno);
		log.info(String.format("Aluno: %s. DELETADO!", aluno.getNome()));
	}
	
	@Transacional
	@SuppressWarnings("unchecked") // coloquei supress pq não faço ideia de como resolver esse warning, e a resolução automática é meme
	public List<Aluno> todosOsAlunos() {
		return em.createNativeQuery("SELECT * FROM alunos", Aluno.class).getResultList();
	}
	
}
