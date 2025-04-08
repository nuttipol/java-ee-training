package my.example.chapter01.dao;

import java.sql.SQLException;
import java.util.List;

import my.example.chapter01.model.Employee;


public interface EmployeeDao {
	public Employee find(String id) throws SQLException;
	public List<Employee> findByName(String name)throws SQLException;
	public void insert(Employee Person) throws SQLException;
//	public Person update(Person Person) throws SQLException;
//	public Person delete(Person Person) throws SQLException;
}
