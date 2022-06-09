package com.sts.blogging_api.security;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sts.blogging_api.exception.ResourceNotFound;
import com.sts.blogging_api.repositories.UserRepo;

public class CustomUserServiceDetails implements UserDetailsService {

	
	@Autowired
	UserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	          User user=       (User) this.userRepo.findByEmail(email).orElseThrow(()->new ResourceNotFound("User", "email"+email,(long) 0));
			return (UserDetails) user;
	}

}
