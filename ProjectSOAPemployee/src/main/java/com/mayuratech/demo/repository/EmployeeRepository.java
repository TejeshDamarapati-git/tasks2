package com.mayuratech.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mayuratech.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}