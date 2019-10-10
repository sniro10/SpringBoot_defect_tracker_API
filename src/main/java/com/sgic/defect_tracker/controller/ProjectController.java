package com.sgic.defect_tracker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.defect_tracker.model.Project;
import com.sgic.defect_tracker.repository.ProjectRepositories;
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:3001", "http://localhost:4200" })
@RestController
@RequestMapping("projectinfo")
public class ProjectController {
	@Autowired
	ProjectRepositories projectRepositories;

	@PostMapping(value = "/project")
	public ResponseEntity<?> createProject(@RequestBody Project project){
		projectRepositories.save(project);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	@GetMapping("/project")
	  public List<Project> getProject() {
		return projectRepositories.findAll();
	}
	@DeleteMapping("/project/{id}")
	public ResponseEntity<Long> deleteProject (@PathVariable Long id){
		projectRepositories.deleteById(id);
		return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
	}
	@PutMapping("/updateproject")
	public ResponseEntity<?> updateProject(@RequestBody Project project){
		projectRepositories.save(project);
		return new ResponseEntity<Object>(HttpStatus.OK);
	
	}
	@GetMapping("/getproject/{id}")
	public ResponseEntity<Project> getProjectById(@PathVariable("id") Long id){
		return new ResponseEntity<Project>(projectRepositories.findProjectById(id), HttpStatus.OK);
	}
	
}
