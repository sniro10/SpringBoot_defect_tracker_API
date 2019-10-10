package com.sgic.defect_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.defect_tracker.model.Defect;
import com.sgic.defect_tracker.model.Employee;


public interface DefectRepositories extends JpaRepository<Defect, Long>{
	Defect findDefectById(Long id);

}
