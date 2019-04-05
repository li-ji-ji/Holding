package com.holding.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.holding.po.Menu;
import com.holding.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	 @Autowired
	 private MenuService menuService;
	 
	 @RequestMapping("/getfirstmenu.do")
	 public String getFirstMenu(HttpSession session,HttpServletRequest request,HttpServletResponse response)throws Exception{
		 List<Menu> firstMenu=menuService.getFirstMenu();
		 int menuLength=firstMenu.size();
		 System.out.println(firstMenu);
		 session.setAttribute("menuLength", menuLength);
		 session.setAttribute("firstMenu", firstMenu);
		 System.out.println(firstMenu);
		 return "menu/BackgroundMainPage";
	 }
	 
	 @RequestMapping("/getsecondmenu.do")
	 @ResponseBody
	 public String getSecondMenu(HttpSession session,HttpServletRequest request,HttpServletResponse response)throws Exception{
		 String menuName=request.getParameter("menuname");
		 System.out.println("返回菜单名："+menuName);
		 Integer menuId=menuService.getMenuId(menuName);
		 System.out.println("返回菜单id"+menuId);
		 List<Menu> secondMenu=menuService.getSecondMenu();
		 System.out.println("二级菜单："+secondMenu);
		 System.out.println("二级菜单长度："+secondMenu.size());
		 session.setAttribute("menuMid", menuId);
		 session.setAttribute("secondMenuLength", secondMenu.size());
		 session.setAttribute("secondMenu", secondMenu);
		 return "menu/BackgroundMainPage";
	 }
	 @RequestMapping("/addmenu.do")
	 public String addMenu(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 return "menu/BackgroundMainPage";
		 
	 }
}