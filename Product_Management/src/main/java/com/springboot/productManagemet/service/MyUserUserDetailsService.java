package com.springboot.productManagemet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.springboot.productManagemet.dao.MyUserDao;
import com.springboot.productManagemet.entity.MyUser;


@Component
public class MyUserUserDetailsService implements UserDetailsService{
	@Autowired
	MyUserDao dao;
	
	@Autowired
	UserDetails userDetails;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		System.out.println(username);
		MyUser user=dao.findMyUserByName(username);
		System.out.println(user);
		if (user ==null) throw new UsernameNotFoundException("user with this username not found!!" +userDetails);
		else{
			MyUserUserDetails myUserUserDetails = (MyUserUserDetails)userDetails;
			myUserUserDetails.setUser(user);
			return myUserUserDetails;
		
		}
	}

}
