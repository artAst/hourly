package org.hourly.management.dao;

import org.hourly.management.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao extends JpaRepository<Account, Long>{
	
	public Account findByUsername(String username);
}
