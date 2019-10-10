package com.sgic.defect_tracker.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "employee")
public class Employee {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
		 * 
		 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String dateOfBirth;
	
	/*//-----------  EMPLOYEE AND DEFECTS  ----------------------------//
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	private Set<Defect> defect;
		public Set<Defect> getDefect() {
			return defect;
		}
	
		public void setDefect(Set<Defect> defect) {
			this.defect = defect;
		}
	*/

	
	//------------------ RELATIONSHIP BETWEEN EMPLOYEE AND PROJECT  -------------------//
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.PERSIST})
	@JoinColumn(name = "project_id", nullable = true)
	private Project project;
		public Project getProject() {
			return project;
		}

		public void setProject(Project project) {
			this.project = project;
		}
	
	
	
	public Employee() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
