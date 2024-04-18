package com.herick.repository;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.herick.model.Professor;
import com.herick.util.Transacional;

public class Professores implements Serializable {

    public static final Logger log = Logger.getLogger(Professores.class.getName());
    private static final long serialVersionUID = 1L;
    private EntityManager em;
    
    public Professores() {
        this.em = Persistence.createEntityManagerFactory("codecraftPU").createEntityManager();
    }

    @Transacional
    public Professor byId(Long id) {
        return em.find(Professor.class, id);
    }

    @Transacional
    public void save(Professor professor) {
        em.getTransaction().begin();
        em.persist(professor);
        em.getTransaction().commit();
    }

    @Transacional
    public void deleteById(Long id) {
        em.getTransaction().begin();
        Professor professor = byId(id);
        em.remove(professor);
        em.getTransaction().commit();
        log.info(String.format("Professor: %s. DELETADO!", professor.getNomeProfessor()));
    }

    @Transacional
    @SuppressWarnings("unchecked")
    public List<Professor> todosProfessores() {
        return em.createNativeQuery("SELECT * FROM Professores", Professor.class).getResultList();
    }
}

