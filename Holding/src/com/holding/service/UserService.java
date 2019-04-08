package com.holding.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.holding.po.User;

@Service
public interface UserService {
	
	//查询所有用户
	List<User> getAll() throws Exception;
	
	//根据用户名查询用户
	User getUserByName(String name) throws Exception;
}
