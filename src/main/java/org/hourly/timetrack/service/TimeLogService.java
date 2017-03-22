package org.hourly.timetrack.service;

import org.hourly.timetrack.dto.TimeLogDto;

public interface TimeLogService {
	
	public TimeLogDto logEmployeeTime();
	
	public TimeLogDto logEmployeeTime(String employeeId);
	
	public TimeLogDto getLatestLoggedTime();
	
	public TimeLogDto getLatestLoggedTime(String employeeId);
}
