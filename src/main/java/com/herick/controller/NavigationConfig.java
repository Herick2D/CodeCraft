package com.herick.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
@ManagedBean
public class NavigationConfig implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public String navAlunos() {
		return "pagAluno?faces-redirect=true";
	}
	
	public String navProfessores() {
		return "pagProfessor?faces-redirect=true";
	}
	
	public String navCursos() {
		return "pagCurso?faces-redirect=true";
	}

	
}
