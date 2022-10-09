package springboot.EmployeeManagement.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springboot.EmployeeManagement.entity.Employee;
import springboot.EmployeeManagement.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class DemoController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/list")
	public String listEmployees(Model theModel)
	{
		List<Employee> theEmployee = employeeService.findAll();
		
		theModel.addAttribute("employees", theEmployee);
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		Employee theEmployee = new Employee();		
		theModel.addAttribute("employees", theEmployee);
		return "employees/employee-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,
									Model theModel) {
		
		// get the employee from the service
		Employee theEmployee = employeeService.findById(theId);
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("employees", theEmployee);
		
		// send over to our form
		return "employees/employee-form";			
	}
	

	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId,
			Model theModel)
	{
		employeeService.deletebyId(theId);
		return "redirect:/employees/list";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employees") Employee theEmployee) {
		
		// save the employee
		employeeService.save(theEmployee);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}
	
	
	
	
}