package com.sgic.defect_tracker.controller;

import java.util.List;

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

import com.sgic.defect_tracker.model.Defect;
import com.sgic.defect_tracker.model.Employee;
import com.sgic.defect_tracker.repository.DefectRepositories;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:3001", "http://localhost:4200" })
@RestController
@RequestMapping("defectinfo")
public class DefectController  {
	@Autowired
	DefectRepositories defectRepositories;
	
	@PostMapping(value = "/defect")
	public ResponseEntity<?> createNote(@RequestBody Defect defect){
		defectRepositories.save(defect);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	@GetMapping("/defect")
	  public List<Defect> getDefect() {
		return defectRepositories.findAll();
	}
	@DeleteMapping("/defect/{id}")
	public ResponseEntity<Long> deleteDefect (@PathVariable Long id){
		defectRepositories.deleteById(id);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
	
	@PutMapping("/updatedefect")
	public ResponseEntity<?> updateDefect(@RequestBody Defect defect){
		defectRepositories.save(defect);
		return new ResponseEntity<Object>(HttpStatus.OK);
	
	}
	@GetMapping("/getdefect/{id}")
	public ResponseEntity<Defect> getDefectById(@PathVariable("id") Long id){
		return new ResponseEntity<Defect>(defectRepositories.findDefectById(id), HttpStatus.OK);
	}
	
	
}
