package com.sgic.defect_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.defect_tracker.model.Employee;
import com.sgic.defect_tracker.model.Project;


public interface EmployeeRepositories extends JpaRepository<Employee, Long>{
	Employee findEmployeeById(Long id);
}
