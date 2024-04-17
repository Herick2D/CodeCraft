package com.herick.controller;

import com.herick.model.Curso;
import com.herick.repository.Cursos;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
@ManagedBean
public class CursoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cursos cursos = new Cursos();
	private Curso cursoSample = new Curso();
	private Curso cursoToCreate = new Curso();
	private Curso cursoFounded = new Curso();


    public List<Curso> todosCursos() {
        return cursos.findAllCurso();
    }

	public void createCurso() {
		cursos.save(cursoToCreate);
	}

	public Curso getCursoById(Long id) {
		cursoFounded = cursos.byId(id);
		return cursoFounded;
	}

	public void deleteCurso(Long id) {
		cursos.deleteById(id);
	}

	public Cursos getCursos() {
		return cursos;
	}

	public void setCursos(Cursos cursos) {
		this.cursos = cursos;
	}

	public Curso getCursoSample() {
		return cursoSample;
	}

	public void setCursoSample(Curso cursoSample) {
		this.cursoSample = cursoSample;
	}

	public Curso getCursoToCreate() {
		return cursoToCreate;
	}

	public void setCursoToCreate(Curso cursoToCreate) {
		this.cursoToCreate = cursoToCreate;
	}

	public Curso getCursoFounded() {
		return cursoFounded;
	}

	public void setCursoFounded(Curso cursoFounded) {
		this.cursoFounded = cursoFounded;
	}
	
	
}

	
