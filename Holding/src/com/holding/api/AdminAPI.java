package com.holding.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.holding.po.Admin;
import com.holding.po.ResultMsg;
import com.holding.service.AdminService;

@CrossOrigin
@RestController
@RequestMapping("/api/admin")
public class AdminAPI {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/index.do")
	public ResultMsg menu() {
		ResultMsg msg=new ResultMsg();
		msg.setCode("100");
		msg.setMsg("接口调用成功");
		return msg;
	}
	
	@RequestMapping("/all.do")
	public List<Admin>getAll() throws Exception{
		return adminService.getAll();
	}
}
