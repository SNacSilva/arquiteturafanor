package br.edu.fanor.progweb.arquitetura.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fanor.progweb.arquitetura.entity.Usuario;
import br.edu.fanor.progweb.arquitetura.exceptions.DAOException;

/**
 * @author patrick.cunha
 * 
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class UsuarioDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void salvar(Usuario usuario) {
		entityManager.persist(usuario);
	}
	
	public void atualizar(Usuario usuario){
		entityManager.merge(usuario);
	}
	
	public Usuario buscarPorEmail(String email){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
		Root<Usuario> usuario = criteriaQuery.from(Usuario.class);
		criteriaQuery.where(criteriaBuilder.equal(usuario.<String>get("email"), email));
		
		Query query = entityManager.createQuery(criteriaQuery);
		try {
			return (Usuario)query.getSingleResult();
		} catch(NoResultException e){
			return null;
		}
	}
	
	public Usuario buscarPorLogin(String login){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
		Root<Usuario> usuario = criteriaQuery.from(Usuario.class);
		criteriaQuery.where(criteriaBuilder.equal(usuario.<String>get("login"), login));
		
		Query query = entityManager.createQuery(criteriaQuery);
		try {
			return (Usuario)query.getSingleResult();
		} catch(NoResultException e){
			return null;
		}
	}
	
	public Usuario buscarPorSenha(String senha){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
		Root<Usuario> usuario = criteriaQuery.from(Usuario.class);
		criteriaQuery.where(criteriaBuilder.equal(usuario.<String>get("senha"), senha));
		
		Query query = entityManager.createQuery(criteriaQuery);
		try {
			return (Usuario)query.getSingleResult();
		} catch(NoResultException e){
			return null;
		}
	}

	public Usuario buscarPorLoginSenha(String login, String senha){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
		Root<Usuario> usuario = criteriaQuery.from(Usuario.class);
		criteriaQuery.where(criteriaBuilder.equal(usuario.<String>get("login"), login));
		criteriaQuery.where(criteriaBuilder.equal(usuario.<String>get("senha"), senha));
		
		Query query = entityManager.createQuery(criteriaQuery);
		try {
			return (Usuario)query.getSingleResult();
		} catch(NoResultException e){
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarPorNome(String nome) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
		Root<Usuario> usuario = criteriaQuery.from(Usuario.class);
		criteriaQuery.where(criteriaBuilder.like(usuario.<String>get("nome"), "%"+nome+"%"));
		
		Query query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	public Usuario buscaPorId(Integer id) throws DAOException {
		String jpql = "select u from Usuario u where u.id = :id";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", id);
		
		try {
			return (Usuario) query.getSingleResult();
		} catch(NoResultException e){
			return null;
		} 
		
	}
	
	public void excluir(Usuario usuario) {
		entityManager.remove(usuario);
	}

	/**
	 * @param id
	 * @return
	 */
	public Usuario buscaPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
