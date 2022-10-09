package springboot.EmployeeManagement.service;

import java.util.List;

import springboot.EmployeeManagement.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int theId);
	
	public void deletebyId(int theId);
	
	public void save(Employee theEmployee);
	
}
