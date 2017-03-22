package org.hourly.core.dao;

import javax.transaction.Transactional;

import org.hourly.core.entity.Employee;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface EmployeeDao extends CrudRepository<Employee, Long>{

}
