package my.example.chapter01.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;

import my.example.chapter01.model.Employee;
import my.example.chapter01.service.EmployeeServiceable;
import my.example.chapter01.service.qulifier.Repository;

@ApplicationScoped
@Repository(name = Repository.MEMORY)
@Default
public class EmployeeServiceMemory implements EmployeeServiceable {

	public static HashMap<String, Employee> employeeMap = new HashMap<String, Employee>();
	@Override
	public void add(Employee employee) {
		employeeMap.put(employee.getId(), employee);
	}

	@Override
	public int update(Employee employee) {
		if (employeeMap.containsKey(employee.getId())) {
			employeeMap.put(employee.getId(),employee);
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public List<Employee> search(Employee employee) {
		List<Employee> employeeList = new ArrayList<Employee>();
		for (Map.Entry<String, Employee> entry : employeeMap.entrySet()) {
			employeeList.add(entry.getValue());
		}
		return employeeList;
	}

	@Override
	public int delete(String id) {
		if (employeeMap.containsKey(id)) {
			employeeMap.remove(id);
			return 1;
		}else {
			return 0;
		}
	}

}
