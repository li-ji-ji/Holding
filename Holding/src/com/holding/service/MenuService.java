package com.holding.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.holding.po.Menu;
import com.holding.vm.MenuVM;

@Service
public interface MenuService {
	
	/*
	 * //查询一级菜单(废弃) List<Menu> getFirstMenu() throws Exception;
	 * 
	 * //插入新菜单(废弃) String addMenu(String menuName,Integer menuMid) throws Exception;
	 * 
	 * //查询二级菜单(废弃) List<Menu> getSecondMenu() throws Exception;
	 * 
	 * //根据菜单名查询菜单ID(废弃) Integer getMenuId(String menuName) throws Exception;
	 */
	
	//查询所有菜单
	List<Menu> getAll() throws Exception;
	
	//根据Mid查询菜单
	List<Menu> getMenuByMid(Integer menuMid) throws Exception;
	
	//根据ID查询菜单
	Menu getMenuById(Integer menuId) throws Exception;
	
	//根据已获得一级菜单id查询二级菜单
	List<MenuVM> getAllMenuByMid()throws Exception;
	
	//根据菜单名获取菜单
	Menu getMenuByName(String menuname) throws Exception;
	
	//插入新菜单
	int insertMenu(Menu menu)throws Exception;
	
	//删除菜单
	void deleteMenu(Integer menuid) throws Exception;
	
	//根据菜单名删除菜单
	int deleteMenuByName(String menuName) throws Exception;
	
	//更新菜单
	Map<String, Object> updateMenu(Menu menu) throws Exception;
}
