package com.holding.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.holding.po.Placeholderrate;
import com.holding.po.PlaceholderrateExample;

@Service
public interface PlaceholderrateService {
/*---------查询--------*/	
	//查询所有占位记录
	List<Placeholderrate> getAll() throws Exception;
	//根据图书馆ID查询最新占位记录
	public Placeholderrate getLastestByLibraryid(Integer libraryId) throws Exception;
	//根据自习室ID查询最新占位记录
	public Placeholderrate getLastestByRoomid(Integer roomId) throws Exception;
/*---------查询--------*/	
	
/*---------删除--------*/	
	//根据ID删除占位记录
	public Placeholderrate getPlaceholderrateById(Integer id) throws Exception;
/*---------删除--------*/	
	
/*---------添加--------*/	
	//添加占位记录
	public int addPlaceholderrate(Placeholderrate placeholderrate) throws Exception;
/*---------添加--------*/	

/*---------删除--------*/
	//根据ID删除占位记录
	public int deletePlaceholderrateById(Integer id) throws Exception;
/*---------删除--------*/	
}
