package com.herick.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.herick.model.Aluno;
import com.herick.repository.Alunos;

@Named
@ViewScoped
@ManagedBean
public class GestaoCodecraftBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Alunos alunos;
	
	private Aluno alunoEscolhido;
	
	public Aluno alunosById() {
		return  alunos.alunoPorId(1L);
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

	
