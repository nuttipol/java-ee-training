package my.example.chapter01.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;

import my.example.chapter01.dao.EmployeeDao;
import my.example.chapter01.dao.qualifier.DatabaseApi;
import my.example.chapter01.model.Employee;


/**
 * This is a sample concept for Implement EmployeeDAO with JPA (can not be run).
 *
 */
@ApplicationScoped
@DatabaseApi(name = DatabaseApi.JPA)
public class EmployeeJpaImpl implements EmployeeDao {
	
	private EntityManager em;

	public Employee find(String id) {
		return em.find(Employee.class, id);
	}

	public List<Employee> findByName(String name) {
		return em.createQuery("SELECT t FROM Person t where t.firstName = :name  ",Employee.class)
				.setParameter("name", name)
				.getResultList();
	}

	@Override
	public void insert(Employee member) throws SQLException {
		em.persist(member);
	}

}
