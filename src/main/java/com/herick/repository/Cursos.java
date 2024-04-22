package com.herick.repository;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.herick.model.Curso;
import com.herick.util.EntityManagerUtil;
import com.herick.util.Transacional;
import lombok.extern.java.Log;

@Log
@ManagedBean(name = "CURSOS")
@RequestScoped
public class Cursos implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManagedProperty(value = "#{EMUTIL}")
    private EntityManagerUtil em;


    @Transacional
    public void save(Curso curso) {
        try {
            log.info("[CREATE CURSO] Salvando curso...");
            getMng().getTransaction().begin();
            getMng().persist(curso);
            getMng().getTransaction().commit();
        } catch (PersistenceException ex) {
            getMng().getTransaction().rollback();
        } finally {
            em.closeEntityManager();
            log.info(String.format("[CURSO CREATED] Curso: %s", curso.getNomeCurso()));
        }
    }

    @Transacional
    public Curso byId(Long id) {
        Curso curso = new Curso();
        try {
            curso = getMng().find(Curso.class, id);
        } catch (IllegalArgumentException ex) {
            getMng().getTransaction().rollback();
            log.severe("[ERROR] Nenhum curso encontrado com esse ID" + id);
            log.severe(ex.getLocalizedMessage());
        } finally {
            em.closeEntityManager();
        }
        return curso;
    }

    @Transacional
    public void deleteById(Long id) {
        em.getEntityManager().getTransaction().begin();
        Curso curso = byId(id);
        em.getEntityManager().remove(curso);
        em.getEntityManager().getTransaction().commit();
        log.info(String.format("Curso: %s. DELETADO!", curso.getNomeCurso()));
    }
    
    @Transacional
    public List<Curso> todosOsCursos() {
        TypedQuery<Curso> query = em.getEntityManager().createQuery("SELECT c FROM Curso c", Curso.class);
        return query.getResultList();
    }

    /****************      GETTER E SETTER       ************************/
    private EntityManager getMng() {
        return em.getEntityManager();
    }
    public EntityManagerUtil getEm() {
        return em;
    }

    public void setEm(EntityManagerUtil em) {
        this.em = em;
    }
}

