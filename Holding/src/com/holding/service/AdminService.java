package com.holding.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.holding.po.Admin;
import com.holding.po.AdminExample;

@Service
public interface AdminService {
	
	//查询管理员
	List<Admin> getAll()throws Exception; 
	Admin getAdminByName(String adminName) throws Exception;
	Admin getAdminById(Integer adminId) throws Exception;
	
	//删除管理员
	int deleteAdminByName(String adminName) throws Exception;
	int deleteAdminById(Integer adminId) throws Exception;
	
	//增加管理员
	int addAdmin(Admin admin) throws Exception;
	
	//更新管理员数据
	int updateAdminById(Admin admin ,AdminExample example) throws Exception;
	int updateAdminByName(Admin admin,AdminExample example) throws Exception;
}
