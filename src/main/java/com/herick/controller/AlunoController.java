package com.herick.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.herick.model.Aluno;
import com.herick.model.Curso;
import com.herick.repository.Alunos;
import com.herick.repository.Cursos;

@Named
@ViewScoped
@ManagedBean
public class AlunoController implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Aluno> pesquisaAlunos = new ArrayList<>();
    private List<Curso> listaCursos = new ArrayList<>();
    private Alunos alunos = new Alunos();
    private Aluno alunoEscolhido = new Aluno();
    private Cursos cursos = new Cursos();
    private Curso cursoSelecionado;

    public static final Logger LOGGER = Logger.getLogger(AlunoController.class.getName());

    public Aluno alunosById() {
        listaCursos.add(cursos.byId(1l));
        listaCursos.add(cursos.byId(2l));
        listaCursos.add(cursos.byId(7l));
        alunoEscolhido = alunos.byId(1L);
        return alunoEscolhido;
    }

    public void todosAlunos() {
        setPesquisaAlunos(alunos.todosOsAlunos());
    }

    public void setAlunos(Alunos alunos) {
        this.alunos = alunos;
    }

    public Aluno getAlunoEscolhido() {
        return alunoEscolhido;
    }

    public void setAlunoEscolhido(Aluno alunoEscolhido) {
        this.alunoEscolhido = alunoEscolhido;
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


    public Curso getCursoSelecionado() {
        return cursoSelecionado;
    }

    public void setCursoSelecionado(Curso cursoSelecionado) {
        this.cursoSelecionado = cursoSelecionado;
    }
}


	
