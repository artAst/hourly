package org.hourly.management.service;

import org.hourly.management.dao.AccountDao;
import org.hourly.management.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDao accountDao;

	@Override
	public Account findByUsername(String username) {
		return accountDao.findByUsername(username);
	}

}
