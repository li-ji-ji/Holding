package com.holding.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holding.mapper.PlaceholderrateMapper;
import com.holding.po.Placeholderrate;
import com.holding.po.PlaceholderrateExample;
import com.holding.service.PlaceholderrateService;

@Service
public class PlaceholderrateServiceImpl implements PlaceholderrateService {

	
	@Autowired
	private PlaceholderrateMapper placeholderrateMapper;
	@Override
	public List<Placeholderrate> getAll() throws Exception {
		// TODO Auto-generated method stub
		return placeholderrateMapper.selectByExample(null);
	}
	@Override
	public Placeholderrate getPlaceholderrateById(Integer id) throws Exception {
		
		return placeholderrateMapper.selectByPrimaryKey(id);
	}
	@Override
	public int deletePlaceholderrateById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		try {
			placeholderrateMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			System.out.println("删除失败");
			return 1;
		}
		return 0;
	}
	@Override
	public int addPlaceholderrateById(Placeholderrate placeholderrate) throws Exception {
		try {
			placeholderrateMapper.insertSelective(placeholderrate);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("添加失败");
			return 1;
		}
		return 0;
	}
	
	//根据图书馆名称查询最新记录
	@Override
	public Placeholderrate getLastestByLibraryid(Integer libraryId) throws Exception {
		return placeholderrateMapper.getPlaceholderrateByMaxId(libraryId);
	}

}
