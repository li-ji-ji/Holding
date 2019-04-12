package com.holding.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.holding.po.Admin;
import com.holding.po.AdminExample;

@Service
public interface AdminService {
	
	/*--------查询--------*/
	//查询所有管理员
	List<Admin> getAll()throws Exception; 
	//根据名字查询管理员
	public Admin getAdminByName(String adminName) throws Exception;
	//根据ID查询管理员
	public Admin getAdminById(Integer adminId) throws Exception;	
	/*--------查询--------*/
	
	/*-------------------分割线---------------------*/
	
	/*--------删除--------*/
	//根据名字删除管理员
	public int deleteAdminByName(String adminName) throws Exception;
	//根据ID删除管理员
	public int deleteAdminById(Integer adminId) throws Exception;	
	/*--------删除--------*/

	/*--------更新--------*/
	//根据ID更新管理员
	public int updateAdminById(Admin admin,AdminExample example) throws Exception;
	//根据名字更新管理员
	public int updateAdminByName(Admin admin,AdminExample example) throws Exception ;	
	/*--------更新--------*/
	
	/*--------添加--------*/
	//添加管理员
	public int addAdmin(Admin admin) throws Exception;
	/*--------添加--------*/
}
