package com.techtraveller.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.techtraveller.Entity.User;
import com.techtraveller.Exception.ResourceNotFoundException;
import com.techtraveller.Repository.UserRepository;

@Service
public class CustomUserDetails implements UserDetailsService {
	@Autowired
private UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user=	this.userRepo.findByEmail(username);
	if(user==null) {
		throw new ResourceNotFoundException("user not found of this username");
	}
	 // Roles ko authority list mein convert karna
    List<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));
	
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);
	}


}