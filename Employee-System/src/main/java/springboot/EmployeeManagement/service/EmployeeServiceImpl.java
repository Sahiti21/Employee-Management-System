package springboot.EmployeeManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.EmployeeManagement.DAO.EmployeeRepository;
import springboot.EmployeeManagement.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	
	private EmployeeRepository employeeDAO;
	
	
	public List<Employee> findAll() {
		return employeeDAO.findAllByOrderByLastNameAsc();
		
	}

	@Override

	public Employee findById(int theId) {
		
		Optional<Employee> result = employeeDAO.findById(theId);
		
		Employee theEmployee = null;
		if (result.isPresent())
			theEmployee = result.get();
		else {
			throw new RuntimeException("Employee not found");
		}
			return theEmployee;
	}

	@Override

	public void save(Employee theEmployee) {
		employeeDAO.save(theEmployee);

	}

	@Override
	public void deletebyId(int theId) {
		employeeDAO.deleteById(theId);
	}

}
