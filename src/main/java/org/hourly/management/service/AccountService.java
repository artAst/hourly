package org.hourly.management.service;

import org.hourly.management.entity.Account;

public interface AccountService {
	
	public Account findByUsername(String username);
}
