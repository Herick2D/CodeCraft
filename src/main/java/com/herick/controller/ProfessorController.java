package com.herick.controller;

import com.herick.model.Professor;
import com.herick.repository.Professores;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
@ManagedBean
public class ProfessorController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<Professor> pesquisaProfessor = new ArrayList<>();
	private Professores professores = new Professores();
	private Professor professorSample = new Professor();
	private Professor professorToCreate = new Professor();
	private Professor professorFounded = new Professor();
	
	
	public Professor todosProfessores() {
		professorSample = professores.byId(1L);
		return professorSample;
	}

	public void createProfessor() {
		professores.save(professorToCreate);
	}

	public Professor getProfessorById(Long id) {
		professorFounded = professores.byId(id);
		return professorFounded;
	}
	
	public void deleteProfessor(Long id) {
		professores.deleteById(id);
	}

	public List<Professor> getPesquisaProfessor() {
		return pesquisaProfessor;
	}

	public void setPesquisaProfessor(List<Professor> pesquisaProfessor) {
		this.pesquisaProfessor = pesquisaProfessor;
	}
	
	
}

	
