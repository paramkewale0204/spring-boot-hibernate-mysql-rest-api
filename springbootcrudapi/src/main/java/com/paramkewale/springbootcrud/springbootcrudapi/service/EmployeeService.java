package com.paramkewale.springbootcrud.springbootcrudapi.service;

import java.util.List;

import com.paramkewale.springbootcrud.springbootcrudapi.model.Employee;

public interface EmployeeService {

	List<Employee> get();
	
	Employee get(int id);
	
	void save(Employee employee);
	
	void delete(int id);
	
}
