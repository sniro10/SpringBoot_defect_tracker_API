package com.sgic.defect_tracker.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;





@Entity
@Table(name = "defects")
public class Defect implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String defect_name;
	private String severity;
	private String priority;
	private String defect_description;

	//---------------------------------------------
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.PERSIST})
	@JoinColumn(name = "employee_id", nullable = true)
	private Employee employee;
	
		public Employee getEmployee() {
			return employee;
		}
	
		public void setEmployee(Employee employee) {
			this.employee = employee;
		}
	//-----------------------------------------------
	/*
	 * 
	//------------- mapped by many to many - project ---------------//
	@ManyToMany(mappedBy = "defects")
	private Set<Project> projects;
	
		public Defect() {
			
		}
		
		public Defect (String defect_name){
		    this.defect_name = defect_name;
		}
		    
		public Defect(String defect_name,String severity,String priority,String defect_description, Set<Project> projects){
			this.severity = severity;
			this.priority = priority;
			this.defect_description = defect_description;
		    this.defect_name = defect_name;
		    this.projects = projects;
		 }
		
	//---------------------------------------------------//
	*/
	
	
	//---------- RELATIONSHIP BETWEEN DEFECT AND PROJECT  ---------//
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.PERSIST})
	@JoinColumn(name = "project_id", nullable = true)
	private Project project;
		public Project getProject() {
			return project;
		}
	
		public void setProject(Project project) {
			this.project = project;
		}
	//-------------------------------------------------------------//
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDefect_name() {
		return defect_name;
	}
	public void setDefect_name(String defect_name) {
		this.defect_name = defect_name;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getDefect_description() {
		return defect_description;
	}
	public void setDefect_description(String defect_description) {
		this.defect_description = defect_description;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
