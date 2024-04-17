package com.herick.controller;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.herick.model.Aluno;
import com.herick.repository.Alunos;

@Named
@ViewScoped
@ManagedBean
public class GestaoCodecraftBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Alunos alunos = new Alunos();
	
	private Aluno alunoEscolhido = new Aluno();
	
	public static final Logger LOGGER = Logger.getLogger(GestaoCodecraftBean.class.getName());
	
	public Aluno alunosById() {
		alunoEscolhido = alunos.alunoPorId(1L);
		return alunoEscolhido;
	}
	
	
	public Aluno todosAlunos() {
		return null;
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
	
	
}

	
