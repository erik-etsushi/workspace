package com.em.managedbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import com.em.ejb.beans.EstudanteEJB;
import com.em.jpa.entity.Estudante;

@ViewScoped
@ManagedBean
public class StudentMB {
	
	@EJB
	private EstudanteEJB estudanteEJB;
	private Estudante estudante = new Estudante();
	private int id;
	private String nome;
	private String sobrenome;
	

	private int serie;
	
	public StudentMB(){
	}
	
	public void createStudent(){
		estudante = estudanteEJB.create(estudante);
	}
	
	public void updateStudent(){
		Estudante student = new Estudante();
		student.setId(id);
		student.setNome(nome);
		student.setSobrenome(sobrenome);
		student.setSerie(serie);
		estudanteEJB.update(student);
	}
	
	public void getStudent(int id){
		Estudante student = estudanteEJB.getEstudante(id);
		this.id = student.getId();
		nome = student.getNome();
		sobrenome = student.getSobrenome();
		serie = student.getSerie();
	}
	
	public void deleteStudent(int id){
		estudanteEJB.remove(id);
	}
	
	public List<Estudante> getAllStudents(){
		return estudanteEJB.getAllStudents();
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public int getSerie() {
		return serie;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}
	
	public EstudanteEJB getEstudanteEJB() {
		return estudanteEJB;
	}

	public void setEstudanteEJB(EstudanteEJB estudanteEJB) {
		this.estudanteEJB = estudanteEJB;
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}
	
}
