package com.herick.controller;

import com.herick.model.Curso;
import com.herick.repository.Cursos;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
@ManagedBean
public class CursoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cursos cursos = new Cursos();
	private Curso cursoSample = new Curso();
	private Curso cursoToCreate = new Curso();
	private Curso cursoFounded = new Curso();


	public Curso todosCursos() {
		cursoSample = cursos.byId(1L);
		return cursoSample;
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
	
	
}

	
