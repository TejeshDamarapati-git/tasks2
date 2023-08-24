package com.mayuratech.demo.service;

import com.mayuratech.demo.entity.Employee;
import com.mayuratech.demo.repository.EmployeeRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {
	
	@Autowired
	 private EmployeeRepository employeeRepository;
	
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	public Optional<Employee> getEmployeeById(Integer Id) {
		return employeeRepository.findById(Id);
	}
}

