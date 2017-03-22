package org.hourly.core.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@NamedQueries( {
	@NamedQuery( name = "DEPARTMENT.FIND-BY-NAME", query = "FROM Department d WHERE lower(d.departmentName) LIKE lower(:name)" ),
	@NamedQuery( name = "DEPARTMENT.FIND-BY-COMPANY", query = "FROM Department d WHERE d.company = :company" )
} )
@Entity
@Table(name = "hourly_dept")
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column( name = "department_id" )
	private Long departmentId;
	
	private Date dateCreated;
	
	private Date lastEdited;
	
	private String departmentName;
	
	@OneToOne( targetEntity = Address.class, cascade = {CascadeType.ALL} )
	private Address address;
	
	@ManyToOne( targetEntity = Company.class, fetch = FetchType.LAZY )
	@JoinColumn( name = "company_id" )
	private Company company;
	
	@OneToMany( targetEntity = Employee.class, mappedBy = "department", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY )
	@Cascade(value={org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	private List<Employee> employees;
	
	public Department() {}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Date getLastEdited() {
		return lastEdited;
	}

	public void setLastEdited(Date lastEdited) {
		this.lastEdited = lastEdited;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
