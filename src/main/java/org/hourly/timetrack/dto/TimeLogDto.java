package org.hourly.timetrack.dto;

import java.util.Date;

import org.hourly.core.dto.BaseDTO;

public class TimeLogDto extends BaseDTO {
	
	private static final long serialVersionUID = -4045127763571985569L;

	private String firstName;
	
	private String lastName;
	
	private Date logTime;

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

	public Date getLogTime() {
		return logTime;
	}

	public void setLogTime(Date loggedTime) {
		this.logTime = loggedTime;
	}
}
