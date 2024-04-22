package com.herick.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.herick.model.Aluno;
import com.herick.model.Curso;
import com.herick.repository.Alunos;
import com.herick.repository.Cursos;
import lombok.extern.java.Log;

@Log
@ManagedBean
@RequestScoped
public class AlunoController implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManagedProperty(value = "#{ALUNOS}")
    private Alunos alunos;

    @ManagedProperty(value = "#{CURSOS}")
    private Cursos cursos;

    private List<Aluno> pesquisaAlunos = new ArrayList<>();
    private List<Curso> listaCursos = new ArrayList<>();

    private Aluno alunoEscolhido = new Aluno();
    private Aluno alunoToCreate = new Aluno();
    private Curso cursoSelecionado = new Curso();


    public void preRender() {
        setListaCursos(cursos.todosOsCursos());
        setPesquisaAlunos(alunos.todosOsAlunos());
        log.info("[CODECRAFT - ALUNO PAGE] Configs pre-render inicializadas!");
    }

    public void createAluno() {
        log.info("[CODECRAFT - ALUNO PAGE] Create Aluno...");
        alunoToCreate.getCursos().add(cursoSelecionado);
        alunos.save(alunoToCreate);
    }

    public void deleteById() {
        alunos.deleteById(pesquisaAlunos.get(0).getId());
    }

    /****************      GETTER E SETTER       ************************/
    public Alunos getAlunos() {
        return alunos;
    }

    public void setAlunos(Alunos alunos) {
        this.alunos = alunos;
    }

    public Cursos getCursos() {
        return cursos;
    }

    public void setCursos(Cursos cursos) {
        this.cursos = cursos;
    }

    public List<Aluno> getPesquisaAlunos() {
        return pesquisaAlunos;
    }

    public void setPesquisaAlunos(List<Aluno> pesquisaAlunos) {
        this.pesquisaAlunos = pesquisaAlunos;
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public Aluno getAlunoEscolhido() {
        return alunoEscolhido;
    }

    public void setAlunoEscolhido(Aluno alunoEscolhido) {
        this.alunoEscolhido = alunoEscolhido;
    }

    public Aluno getAlunoToCreate() {
        return alunoToCreate;
    }

    public void setAlunoToCreate(Aluno alunoToCreate) {
        this.alunoToCreate = alunoToCreate;
    }

    public Curso getCursoSelecionado() {
        return cursoSelecionado;
    }

    public void setCursoSelecionado(Curso cursoSelecionado) {
        this.cursoSelecionado = cursoSelecionado;
    }
}


	
