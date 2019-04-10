package com.holding.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.holding.po.Placeholderrate;
import com.holding.po.PlaceholderrateExample;

@Service
public interface PlaceholderrateService {
		
	//查询所有占座记录
	List<Placeholderrate> getAll() throws Exception;
	
	//添加占座记录
	int addPlaceholderrateById(Placeholderrate placeholderrate)throws Exception;
	
	//根据id查询占座记录
	Placeholderrate  getPlaceholderrateById(Integer id) throws Exception;
	
	//根据id删除占座记录
	int deletePlaceholderrateById(Integer id)throws Exception;
}
