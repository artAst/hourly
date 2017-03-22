package org.hourly.timetrack.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hourly.core.entity.Employee;

@Entity
@Table(name = "hourly_time_log")
public class TimeLog {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column( name = "timelog_id" )
	private Long timeLogId;
	
	@Column( name = "log_time" )
	private Date logTime;
	
	@JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
	@ManyToOne
	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Long getTimeLogId() {
		return timeLogId;
	}

	public void setTimeLogId(Long timeLogId) {
		this.timeLogId = timeLogId;
	}

	public Date getLogTime() {
		return logTime;
	}

	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}
}
