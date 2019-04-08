package com.holding.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.holding.mapper.MenuMapper;
import com.holding.po.Menu;
import com.holding.po.MenuExample;
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
		System.out.println("-----------看这里-----------");
		
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
			System.out.println("每个一级菜单："+menu);
			BeanUtils.copyProperties(menu, menuVM);
			System.out.println("每个一级菜单入VM："+menuVM);
			List<Menu> sub=getMenuByMid(menu.getMenuid());
			System.out.println("一级菜单ID"+menu.getMenuid());
			System.out.println(sub);

			System.out.println("-----------好嗨哟-----------");
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
	public void insertMenu(Menu menu) throws SQLException{
		// TODO Auto-generated method stub
		menuMapper.insertSelective(menu);
	}



	@Override
	public void deleteMenu(Integer menuid) throws SQLException {
		// TODO Auto-generated method stub
		menuMapper.deleteByPrimaryKey(menuid);
	}



	@Override
	public void updateMenu(Integer menuid, Menu menu) throws SQLException {
		// TODO Auto-generated method stub
		
	}



	

}
