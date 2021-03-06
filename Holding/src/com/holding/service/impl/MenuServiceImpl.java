package com.holding.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holding.mapper.MenuMapper;
import com.holding.po.Menu;
import com.holding.po.MenuExample;
import com.holding.po.MenuExample.Criteria;
import com.holding.service.MenuService;
import com.holding.vm.MenuVM;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;

	
	@Override
	public List<Menu> getMenuByMid(Integer menuMid) throws Exception {
		//根据menuMid查询菜单
		MenuExample example=new MenuExample();
		MenuExample.Criteria criteria=example.createCriteria();
		criteria.andMenumidEqualTo(menuMid);
		List<Menu> menus=menuMapper.selectByExample(example);
		System.out.println(menus);
		
		return menus;
	}



	@Override
	public List<MenuVM> getAllMenuByMid() throws Exception {
		// 根据已获得一级菜单id查询二级菜单
		List<Menu> menus=getMenuByMid(0);
		List<MenuVM> vms=new ArrayList<>();
		MenuVM menuVM=null;
		for(Menu menu:menus) {
			menuVM=new MenuVM();
			System.out.println(menuVM);
			BeanUtils.copyProperties(menu, menuVM);
			List<Menu> sub=getMenuByMid(menu.getMenuid());
			System.out.println(sub);
			menuVM.setMenus(sub);
			vms.add(menuVM);
		}
		return vms;
		
		
		
	}



	@Override
	public List<Menu> getAll() throws Exception {
		// TODO Auto-generated method stub
		return menuMapper.selectByExample(null);
	}


	@Override
	public int insertMenu(Menu menu) throws SQLException{
		try {
			menuMapper.insertSelective(menu);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("添加失败");
			return 0;
		}
		return 1;
	}



	@Override
	public void deleteMenu(Integer menuid) throws SQLException {
		// TODO Auto-generated method stub
		menuMapper.deleteByPrimaryKey(menuid);
	}



	@Override
	public Map<String, Object> updateMenu(Menu menu) throws SQLException {
		// TODO Auto-generated method stub
		Map<String, Object> msg = new HashMap<>();
		try {
			menuMapper.updateByPrimaryKeySelective(menu);
			msg.put("success", true);
			msg.put("msg", "修改成功");
		} catch (Exception e) {
			msg.put("success", false);
			msg.put("msg", "修改失败");
		}
		return msg;
	}



	@Override
	public Menu getMenuByName(String menuname) throws Exception {
		MenuExample menuExample=new MenuExample();
		Criteria criteria=menuExample.createCriteria();
		criteria.andMenunameEqualTo(menuname);
		return menuMapper.selectByExample(menuExample).get(0);
	}



	//根据菜单名删除菜单
	@Override
	public int deleteMenuByName(String menuName) throws SQLException {
		// TODO Auto-generated method stub
		MenuExample menuExample =new MenuExample();
		Criteria criteria = menuExample.createCriteria();
		criteria.andMenunameEqualTo(menuName);
		try {
			menuMapper.deleteByExample(menuExample);
		} catch (Exception e) {
			System.out.println("删除失败");
			return 0;
		}
		return 1;
	}



	@Override
	public Menu getMenuById(Integer menuId) throws Exception {
		return menuMapper.selectByPrimaryKey(menuId);
	}



	

}
