package com.holding.service;

import java.sql.SQLException;
import java.util.List;

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
	
	//根据已获得一级菜单id查询二级菜单
	List<MenuVM> getAllMenuByMid()throws Exception;
	
	//插入新菜单
	void insertMenu(Menu menu)throws SQLException;
	
	//删除菜单
	void deleteMenu(Integer menuid) throws SQLException;
	
	//更新菜单
	void updateMenu(Integer menuid,Menu menu) throws SQLException;
}
