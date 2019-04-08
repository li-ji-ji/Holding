package com.holding.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holding.mapper.AdminMapper;
import com.holding.po.Admin;
import com.holding.service.AdminService;

@Service
public class AdminServiceImp implements AdminService {

	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public List<Admin> getAll() throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.selectByExample(null);
	}

}
