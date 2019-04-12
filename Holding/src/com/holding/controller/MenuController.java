package com.holding.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.holding.po.Menu;
import com.holding.service.MenuService;
import com.holding.utils.LayUIJSON;
import com.holding.vm.MenuVM;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	 @Autowired
	 private MenuService menuService;
	 
	 @RequestMapping("/getfirstmenu.do")
	 public String getFirstMenu(Model model,HttpServletRequest request,HttpServletResponse response)throws Exception{
		 List<MenuVM> firstMenu=menuService.getAllMenuByMid();
		 model.addAttribute("menus", firstMenu);
		 return "menu/BackgroundMainPage";
	 }
	 
	/*（废弃）根据一级菜单获取二级菜单
	 * @RequestMapping("/getsecondmenu.do")
	 * 
	 * @ResponseBody public String getSecondMenu(HttpSession
	 * session,HttpServletRequest request,HttpServletResponse response)throws
	 * Exception{ String menuName=request.getParameter("menuname");
	 * System.out.println("返回菜单名："+menuName); Integer
	 * menuId=menuService.getMenuId(menuName); System.out.println("返回菜单id"+menuId);
	 * List<Menu> secondMenu=menuService.getSecondMenu();
	 * System.out.println("二级菜单："+secondMenu);
	 * System.out.println("二级菜单长度："+secondMenu.size());
	 * session.setAttribute("menuMid", menuId);
	 * session.setAttribute("secondMenuLength", secondMenu.size());
	 * session.setAttribute("secondMenu", secondMenu); return
	 * "menu/BackgroundMainPage"; }
	 */


	// 获取菜单列表数据
	@RequestMapping("/getMenuList.do")
	@ResponseBody
	public LayUIJSON getMenuList() throws Exception {
		LayUIJSON layUIJSON = new LayUIJSON();
		layUIJSON.setData(menuService.getAll());
		System.out.println(layUIJSON);
		return layUIJSON;
	}

	// 根据获得的菜单名获取菜单url
	@RequestMapping("/getMenuUrlByMenuname.do")
	@ResponseBody
	public String getMenuUrlByMenuname(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String menuName = (String) request.getParameter("menuname");
		Menu menu = menuService.getMenuByName(menuName);
		return menu.getUrl();
	}

	// 跳转到菜单列表
	@RequestMapping("/getMenuTable.do")
	public String getMenuTable() throws Exception {
		return "menu/MenuTable";
	}

	// 跳转到菜单表单
	@RequestMapping("/getMenuFrom.do")
	public String getMenuFrom() throws Exception {
		return "menu/MenuFrom";
	}

	
	

	//根据菜单名删除菜单
	@RequestMapping("/deleteMenuByName.do")
	public String deleteMenuByName(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception{
		String menuName=request.getParameter("menuname");
		menuService.deleteMenuByName(menuName);
		return "menu/MenuTable";
	}
	
	//修改菜单数据
	@RequestMapping("/updateMenuByName.do")
	public String updateMenuByName(Model model,HttpSession session, HttpServletRequest request, HttpServletResponse response)throws Exception{

		return null;
		 
	 }
	 
	 @RequestMapping("/addmenu.do")
	 public String addMenu(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 return "menu/BackgroundMainPage";
		 
	 }
	 
	 
}
