package com.marasinghe.hrservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marasinghe.hrservice.models.Employee;
import com.marasinghe.hrservice.models.EmployeesList;


@RestController
@RequestMapping("/hr")
public class HrResources {

    List<Employee> employees = Arrays.asList(
		new Employee("E1", "Dean", "Winchester", "MediTech"),
		new Employee("E2", "Sam", "Clif", "Surgery"),
		new Employee("E3", "Damen", "Salvotore", "Dentistry")
		);

 
 //getEmployees method  to return EmployeesList object of employees
   @RequestMapping("/employees")   
   public EmployeesList getEmployees() {
	   
	 EmployeesList employeesList = new EmployeesList();
	 employeesList.setEmployees(employees);
	 
	 return employeesList;
 }
 
 @RequestMapping("/employees/{Id}")
 //getEmployeeById method will take an id to return a single employee
 public Employee getEmployeeById (@PathVariable("Id") String Id) {
	  Employee e = employees.stream()
			  .filter(employee -> Id.equals(employee.getId()))
			  .findAny()
			  .orElse(null);
	  return e;
 }
	
}
