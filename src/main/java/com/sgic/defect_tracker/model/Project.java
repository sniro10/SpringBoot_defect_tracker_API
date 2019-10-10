package com.sgic.defect_tracker.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String project_name;
	private String project_description;
/*
	//-------------------------------------   ENTITI RELATIONSHIP OF MANY TO MANY   ----------------------------------//
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "project_defect", joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "defect_id", referencedColumnName = "id"))
	private Set<Defect> defects;
	

	  public Project(String project_name){
	    this.project_name = project_name;
	  }
	  public Project(String project_name,String project_description){
		    this.project_name = project_name;
		  }
	  
	  public Project(String project_name, String project_description, String description, Set<Defect> defects){
	    this.project_name = project_name;
	    this.project_description = project_description;
	    this.defects = defects;
	  }
	
	//------------------------------------------------------
	@Column(name = "employee_id", nullable = true)
	private Integer employeeId;
	
		public Integer getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(Integer employeeId) {
			this.employeeId = employeeId;
	}
	//-------------------------------------------------------
	*/
	

		
	public Project() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getProject_description() {
		return project_description;
	}
	public void setProject_description(String project_description) {
		this.project_description = project_description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
