package com.holding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.holding.service.UserService;
import com.holding.utils.LayUIJSON;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	
	@RequestMapping("/getUserTable.do")
	public String getUserTable() throws Exception{
		return "menu/MenuTable";
	}
}
