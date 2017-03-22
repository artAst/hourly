package org.hourly.timetrack.rest;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hourly.timetrack.dto.TimeLogDto;
import org.hourly.timetrack.service.TimeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Produces( { MediaType.APPLICATION_JSON } )
@RequestMapping( "/timelogging" )
public class EmployeeTimeLoggingService {
	
	@Autowired
	private TimeLogService timeLogService;
	
	@RequestMapping( method = RequestMethod.GET )
	public TimeLogDto logEmployeeTime() {
		return timeLogService.logEmployeeTime();
	}
}
