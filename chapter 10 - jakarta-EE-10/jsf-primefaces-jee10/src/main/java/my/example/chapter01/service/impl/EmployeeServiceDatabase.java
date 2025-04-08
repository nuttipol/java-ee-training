package my.example.chapter01.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import my.example.chapter01.dao.EmployeeDao;
import my.example.chapter01.dao.qualifier.DatabaseApi;
import my.example.chapter01.model.Employee;
import my.example.chapter01.service.EmployeeServiceable;
import my.example.chapter01.service.qulifier.Repository;

@ApplicationScoped
@Repository(name = Repository.DATABASE)
public class EmployeeServiceDatabase implements EmployeeServiceable {

	@Inject
	@DatabaseApi(name = DatabaseApi.JDBC)
	private EmployeeDao employeeDao;
	
	@Override
	public void add(Employee employee) {
		try {
			employeeDao.insert(employee);
		} catch (SQLException e) {
		}
	}

	@Override
	public int update(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Employee> search(Employee employee) {
		try {
			return employeeDao.findByName(employee.getFirstName());
		} catch (SQLException e) {
			return new ArrayList<Employee>();
		}
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
