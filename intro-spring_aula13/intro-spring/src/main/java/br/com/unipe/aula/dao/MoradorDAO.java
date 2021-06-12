package br.com.unipe.aula.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.unipe.aula.model.Morador;

@Repository
public class MoradorDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
		
	public MoradorDAO() {
	
	}
	
	@Transactional(readOnly = false)
	public void salvar(Morador morador) {
		entityManager.persist(morador);
	
	}
	
	@Transactional(readOnly = true)
	public List<Morador> getAll(){	
		String jpql = "from Morador u";
		TypedQuery<Morador> consulta = entityManager.createQuery(jpql, Morador.class);
		
		return consulta.getResultList();
	}
	
	public Morador getId(int id) {
		return null;
	}
	
	public void excluir(int id) {
		
	}
	
	public void editar(int id, Morador morador) {
		
	}

}
