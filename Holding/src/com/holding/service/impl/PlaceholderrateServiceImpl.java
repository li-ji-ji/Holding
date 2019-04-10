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

}
