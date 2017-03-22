package org.hourly.timetrack.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hourly.core.entity.Employee;
import org.hourly.timetrack.entity.TimeLog;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface TimeLogDao extends CrudRepository<TimeLog, Long>{
	
	public List<TimeLog> findByEmployeeOrderByLogTimeDesc(Employee employee);
}
