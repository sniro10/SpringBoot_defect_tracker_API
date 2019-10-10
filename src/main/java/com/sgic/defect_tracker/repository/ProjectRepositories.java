package com.sgic.defect_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgic.defect_tracker.model.Project;


@Repository
public interface ProjectRepositories extends JpaRepository<Project, Long> {

	Project findProjectById(Long id);
}
