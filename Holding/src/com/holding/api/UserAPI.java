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
import com.holding.vm.MsgVm;

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
	public MsgVm getUserByName(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		MsgVm msg=new MsgVm();
		User user=userService.getUserByName(name);
		//判断是否存在该用户
		if(user == null) {
			msg.setCode(0);
			msg.setMsg("不存在该用户！");
			return msg;
		}
		//密码校验
		if(!password.equals(user.getPassword())) {
			msg.setCode(0);
			msg.setMsg("密码错误！");
			return msg;
		}
		msg.setCode(1);
		msg.setMsg("登入成功！");
		msg.setUser(user);
		return msg;
	}
}
