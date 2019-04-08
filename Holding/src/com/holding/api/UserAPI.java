package com.holding.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.holding.po.ResultMsg;
import com.holding.po.User;
import com.holding.service.UserService;
import com.holding.utils.LayUIJSON;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserAPI {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/index.do")
	public ResultMsg menu() {
		ResultMsg msg=new ResultMsg();
		msg.setCode("100");
		msg.setMsg("接口调用成功");
		return msg;
	}
	
	@RequestMapping("/getUserList.do")
	 public LayUIJSON getUserList() throws Exception{
		 LayUIJSON layUIJSON=new LayUIJSON();
		 layUIJSON.setData(userService.getAll());
		 return layUIJSON;
	 }
	
	@RequestMapping("/all.do")
	public List<User> getAll()throws Exception{
		return userService.getAll();
	}
	
	//根据用户名获取用户
	@RequestMapping("/getuserbyname.do")
	public User getUserByName(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String name=request.getParameter("name");
		return userService.getUserByName(name);
	}
}
