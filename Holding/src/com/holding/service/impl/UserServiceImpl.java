package com.holding.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holding.mapper.UserMapper;
import com.holding.po.User;
import com.holding.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> getAll() throws Exception {
		// TODO Auto-generated method stub
		return userMapper.selectByExample(null);
	}

	@Override
	public User getUserByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.selectUserByName(name);
	}

}
