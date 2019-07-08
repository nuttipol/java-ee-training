package my.example.dao.jpa;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import my.example.dao.ProgrammerDao;
import my.example.jpa.lab03.Programmer;

public class ProgrammerJpaImpl implements ProgrammerDao {
	private EntityManager em;

	public ProgrammerJpaImpl(EntityManager em) {
		this.em = em;
	}

	public Programmer find(long id) {
		return em.find(Programmer.class, id);
	}

	public List<Programmer> findByName(String name) {
		return em.createQuery("SELECT t FROM Programmer t where t.name = :name  ",Programmer.class)
				.setParameter("name", name)
				.getResultList();
	}

	public List<Programmer> findByCriteria(Programmer programmer) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Programmer> cq = cb.createQuery(Programmer.class);
		List<Predicate> predicates = new ArrayList<>();
		
		Root<Programmer> c = cq.from(Programmer.class);

		if (programmer.getId()!=null){
			predicates.add(cb.equal(c.get("id"), programmer.getId()));
		}
		
		if (programmer.getName()!=null){
			predicates.add(cb.equal(c.get("name"), programmer.getName())); 
		}
		
		cq.where(predicates.toArray(new Predicate[]{}));
		
		TypedQuery<Programmer> query = em.createQuery(cq);
		
		return query.getResultList();
	}

	@Override
	public Programmer insert(Programmer programmer) throws SQLException {
		return em.merge(programmer);
	}

}
