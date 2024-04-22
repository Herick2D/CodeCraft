package com.herick.repository;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.herick.model.Aluno;
import com.herick.util.EntityManagerUtil;
import com.herick.util.Transacional;
import lombok.extern.java.Log;

@Log
@ManagedBean(name = "ALUNOS")
@RequestScoped
public class Alunos implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManagedProperty(value = "#{EMUTIL}")
    private EntityManagerUtil em;


    public void save(Aluno aluno) {
        try {
            log.info("[CREATE ALUNO] Salvando aluno...");
            getMng().getTransaction().begin();
            getMng().persist(aluno);
            getMng().getTransaction().commit();
        } catch (PersistenceException ex) {
            getMng().getTransaction().rollback();
        } finally {
            em.closeEntityManager();
            log.info(String.format("[ALUNO CREATED] Aluno: %s", aluno.getNome()));
        }
    }

    @Transacional
    public Aluno byId(Long id) {
        Aluno aluno = new Aluno();
        try {
            aluno = getMng().find(Aluno.class, id);
        } catch (IllegalArgumentException ex) {
            getMng().getTransaction().rollback();
            log.severe("[ERROR] Nenhum aluno encontrado com esse ID" + id);
            log.severe(ex.getLocalizedMessage());
        } finally {
            em.closeEntityManager();
        }
        return aluno;
    }

    public void deleteById(Long id) {
        getMng().getTransaction().begin();
        Aluno aluno = byId(id);
        getMng().remove(aluno);
        getMng().getTransaction().commit();
        log.info(String.format("Aluno: %s. DELETADO!", aluno.getNome()));
    }

    @Transacional
    @SuppressWarnings("unchecked")
    // coloquei supress pq não faço ideia de como resolver esse warning, e a resolução automática é meme
    public List<Aluno> todosOsAlunos() {
        return getMng().createNativeQuery("SELECT * FROM alunos", Aluno.class).getResultList();
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
