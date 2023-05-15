package com.inmemory.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.inmemory.entity.UserData;
import com.inmemory.repo.UserRepo;

@Component
public class UserDataUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo uRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserData> findByUserName = uRepo.findByUserName(username);
		System.out.println("User Name : " + findByUserName);
		return findByUserName.map(UserDataUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found " + username));

	}

}
