package com.holding.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.holding.po.Admin;

@Service
public interface AdminService {
	
	//查询所有管理员
	List<Admin> getAll()throws Exception; 
}
