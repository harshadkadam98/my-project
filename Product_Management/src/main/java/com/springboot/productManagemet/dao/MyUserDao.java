package com.springboot.productManagemet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.productManagemet.entity.MyUser;
 	

public interface MyUserDao extends JpaRepository<MyUser,Integer>{
	
	public MyUser findMyUserByName(String username);

}
