package org.hourly.management.security;

import java.util.ArrayList;
import java.util.Collection;

import org.hourly.management.entity.Account;
import org.hourly.management.entity.Role;
import org.hourly.management.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountUserDetailsService implements UserDetailsService {
	
	@Autowired
	private AccountService accountService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Account account = accountService.findByUsername(username);
		if(account == null) {
			return null;
		}
		
		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		for(Role r : account.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(r.getCode()));
		}
		
		User userDetails = new User(account.getUsername(), account.getPassword(),
									account.isEnabled(), !account.isCredentialsExpired(),
									!account.isExpired(), !account.isLocked(), grantedAuthorities);
		
		return userDetails;
	}

}
