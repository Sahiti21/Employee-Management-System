package springboot.EmployeeManagement.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.EmployeeManagement.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> 
{

	//add method to sort by lastname
	public List<Employee> findAllByOrderByLastNameAsc();
}
