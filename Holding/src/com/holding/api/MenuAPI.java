package com.holding.api;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.holding.po.Menu;
import com.holding.po.ResultMsg;
import com.holding.service.MenuService;
import com.holding.utils.LayUIJSON;

@CrossOrigin
@RestController
@RequestMapping("/api/menu")
public class MenuAPI {
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/index.do")
	public ResultMsg menu() {
		ResultMsg msg=new ResultMsg();
		msg.setCode("100");
		msg.setMsg("接口调用成功");
		return msg;
	}
	@RequestMapping("/all.do")
	public List<Menu> getAll()throws Exception{
		return menuService.getAll();
	}
	
	/*
	 * @RequestMapping("/getMenuList.do") public LayUIJSON getMenuList() throws
	 * Exception{ LayUIJSON layUIJSON=new LayUIJSON();
	 * layUIJSON.setData(menuService.getAll()); System.out.println(layUIJSON);
	 * return layUIJSON; }
	 */
}
