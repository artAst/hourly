package org.hourly.timetrack.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hourly.common.constants.Status;
import org.hourly.core.dao.EmployeeDao;
import org.hourly.core.entity.Employee;
import org.hourly.timetrack.dao.TimeLogDao;
import org.hourly.timetrack.dto.TimeLogDto;
import org.hourly.timetrack.entity.TimeLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service( "timeLogService" )
public class TimeLogServiceImpl implements TimeLogService {
	
	private int ELAPSED_MIN_TIME = 5;
	
	@Autowired
	private TimeLogDao timeLogDao;
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public TimeLogDto logEmployeeTime() {
		return logEmployeeTime(null);
	}

	@Override
	public TimeLogDto logEmployeeTime(String employeeId) {
		TimeLog timelog = new TimeLog();
		TimeLogDto dto = new TimeLogDto();
		Employee emp = null;
		if(!StringUtils.isEmpty(employeeId)) {
			emp = employeeDao.findOne(Long.parseLong(employeeId));
		}
		else {
			emp = employeeDao.findOne(1L);
		}
		timelog.setEmployee(emp);
		timelog.setLogTime(new Date());
		if(checkElapsedLoggedTime(emp)) {
			timeLogDao.save(timelog);
			dto.setFirstName(timelog.getEmployee().getFirstName());
			dto.setLastName(timelog.getEmployee().getLastName());
			dto.setLogTime(timelog.getLogTime());
		}
		else {
			dto.setStatusAndMessage(Status.ERROR, "Elapsed time since last login is less than "+ELAPSED_MIN_TIME+" mins.");
		}
		
		return dto;
	}

	@Override
	public TimeLogDto getLatestLoggedTime() {
		return getLatestLoggedTime(null);
	}

	@Override
	public TimeLogDto getLatestLoggedTime(String employeeId) {
		TimeLogDto dto = new TimeLogDto();
		Employee emp = null;
		if(!StringUtils.isEmpty(employeeId)) {
			emp = employeeDao.findOne(Long.parseLong(employeeId));
		}
		else {
			emp = employeeDao.findOne(1L);
		}
		
		List<TimeLog> logs = timeLogDao.findByEmployeeOrderByLogTimeDesc(emp);
		TimeLog timelog = new TimeLog();
		if(logs != null && !logs.isEmpty()) {
			timelog = logs.get(0);
		}
		if(timelog != null) {
			dto.setFirstName(timelog.getEmployee().getFirstName());
			dto.setLastName(timelog.getEmployee().getLastName());
			dto.setLogTime(timelog.getLogTime());
		}
		
		return dto;
	}
	
	private boolean checkElapsedLoggedTime(Employee emp) {
		List<TimeLog> logs = timeLogDao.findByEmployeeOrderByLogTimeDesc(emp);
		TimeLog log = null;
		if(logs != null && !logs.isEmpty()) {
			log = logs.get(0);
		}
		
		if(log != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(log.getLogTime());
			Long start = System.currentTimeMillis();
			Long elapsed = start - calendar.getTimeInMillis();
			Long elapsedMinutes = elapsed / 60000;
			if(elapsedMinutes < ELAPSED_MIN_TIME) {
				return false;
			}
		}
		return true;
	}
}
