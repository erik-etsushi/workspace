package com.em.ejb.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.em.jpa.entity.Estudante;

/**
 * Session Bean implementation class EstudanteDAO
 */
@Stateless
public class EstudanteEJB {
	
	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public EstudanteEJB() {
        // TODO Auto-generated constructor stub
    }
    
    public Estudante create(Estudante student) {
		em.persist(student);
		return student;
	}

	
	public Estudante update(Estudante student) {
		em.merge(student);
		return student;
	}

	
	public void remove(int id) {
		em.remove(getEstudante(id));
		
	}

	
	public Estudante getEstudante(int id) {
		return em.find(Estudante.class, id);
	}

	
	public List<Estudante> getAllStudents() {
		return em.createNamedQuery("Student.getAll", Estudante.class).getResultList();
	}

}
