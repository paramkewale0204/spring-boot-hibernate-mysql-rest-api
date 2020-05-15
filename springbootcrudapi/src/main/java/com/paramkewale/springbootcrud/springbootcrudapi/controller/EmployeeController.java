package com.paramkewale.springbootcrud.springbootcrudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paramkewale.springbootcrud.springbootcrudapi.model.Employee;
import com.paramkewale.springbootcrud.springbootcrudapi.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/getAllEmployee")
	private List<Employee> get(){
		return employeeService.get();
	}
	
	@PostMapping("/saveEmployee")
	public Employee save(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}
	
	@GetMapping("/getEmployee/{id}")
	private Employee getEmployee(@PathVariable int id) {
		Employee emp =  employeeService.get(id);
		
		if(emp == null) {
			throw new RuntimeException("Employee with id " + id + " does not exist");
		}
		return emp;
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	private void deleteEmployee(@PathVariable int id) {
		employeeService.delete(id);
	}
	
	@PutMapping("updateEmployee")
	public Employee updateEmployee(@RequestBody Employee emp)
	{
		employeeService.save(emp);
		return emp;
	}
	
}
