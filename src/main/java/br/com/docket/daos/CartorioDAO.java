package br.com.docket.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.jpa.criteria.predicate.IsEmptyPredicate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.docket.models.Cartorio;

@Repository
@Transactional
public class CartorioDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void gravar(Cartorio cartorio) {
		if (cartorio.getId() == null)
			manager.persist(cartorio);
		else
			manager.merge(cartorio);
	}
	

	public List<Cartorio> listar() {
		return manager.createQuery("select c from Cartorio c", Cartorio.class).getResultList();
	}
	
	public Cartorio find(Integer id) {
		return manager.find(Cartorio.class, id);
	}

	public void delete(Cartorio cartorio) {
		manager.remove(manager.getReference(Cartorio.class, cartorio.getId()));
		//manager.createQuery("delete from Cartorio c where c.id = :id").setParameter("id", id);
	}
}
