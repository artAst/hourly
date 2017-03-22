package org.hourly.core.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hourly.payroll.entity.Rate;

@NamedQueries( {
	@NamedQuery( name = "EMPLOYEE.FIND-BY-FNAME", query = "FROM Employee e WHERE lower(e.firstName) LIKE lower(:firstName)" ),
	@NamedQuery( name = "EMPLOYEE.FIND-BY-LNAME", query = "FROM Employee e WHERE lower(e.lastName) LIKE lower(:lastName)" ),
	@NamedQuery( name = "EMPLOYEE.FIND-BY-NAME", query = "FROM Employee e WHERE lower(e.firstName) LIKE lower(:name) OR lower(e.lastName) LIKE lower(:name)" )
} )
@Entity
@Table(name = "hourly_employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column( name = "employee_id" )
	private Long employeeId;
	
	private Date dateCreated;
	
	private Date lastEdited;
	
	private String firstName;
	
	private String lastName;
	
	@OneToOne( targetEntity = Address.class, cascade = {CascadeType.ALL} )
	private Address address;
	
	@ManyToOne( targetEntity = Department.class )
	@JoinColumn( name = "department_id" )
	private Department department;
	
	private String employeeType;
	
	@OneToOne( targetEntity = Rate.class, cascade = {CascadeType.ALL} )
	private Rate rate;
	
	public Employee() {}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
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

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public Rate getRate() {
		return rate;
	}

	public void setRate(Rate rate) {
		this.rate = rate;
	}
}
