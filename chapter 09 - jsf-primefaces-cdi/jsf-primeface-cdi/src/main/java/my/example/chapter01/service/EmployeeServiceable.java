package my.example.chapter01.service;

import java.util.List;

import my.example.chapter01.model.Employee;

public interface EmployeeServiceable {
	public void add(Employee employee) ;
	public int update(Employee employee) ;
	public List<Employee> search(Employee employee) ;
	public int delete(String id) ;
}
