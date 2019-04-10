package com.holding.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holding.mapper.AdminMapper;
import com.holding.po.Admin;
import com.holding.po.AdminExample;
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

	@Override
	public Admin getAdminByName(String adminName) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.getAdminByName(adminName);
	}

	@Override
	public Admin getAdminById(Integer adminId) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.selectByPrimaryKey(adminId);
	}

	@Override
	public int deleteAdminByName(String adminName) throws Exception {
		// TODO Auto-generated method stub
		try {
			adminMapper.deleteAdminByName(adminName);
		} catch (Exception e) {
			System.out.println("删除失败");
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteAdminById(Integer adminId) throws Exception {
		try {
			adminMapper.deleteByPrimaryKey(adminId);
		} catch (Exception e) {
			System.out.println("删除失败");
			return 1;
		}
		return 0;
	}

	@Override
	public int addAdmin(Admin admin) throws Exception {
		try {
			adminMapper.insertSelective(admin);
		} catch (Exception e) {
			System.out.println("添加失败");
			return 1;
		}
		return 0;
	}

	@Override
	public int updateAdminById(Admin admin,AdminExample example) throws Exception {
		try {
			adminMapper.updateByExample(admin, example);
		} catch (Exception e) {
			System.out.println("添加失败");
			return 1;
		}
		return 0;
	}

	@Override
	public int updateAdminByName(Admin admin,AdminExample example) throws Exception {
		try {
			adminMapper.updateByExample(admin, example);
		} catch (Exception e) {
			System.out.println("添加失败");
			return 1;
		}
		return 0;
	}

}
