package com.holding.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.holding.po.Placeholderrate;
import com.holding.po.ResultMsg;
import com.holding.service.PlaceholderrateService;

@CrossOrigin
@RestController
@RequestMapping("/api/Placeholderrate")
public class PlaceholderrateAPI {

	@Autowired
	private PlaceholderrateService placeholderrateService;
	
	@RequestMapping("/index.do")
	public ResultMsg menu() {
		ResultMsg msg=new ResultMsg();
		msg.setCode("100");
		msg.setMsg("接口调用成功");
		return msg;
	}
	@RequestMapping("/all.do")
	public List<Placeholderrate> getAll()throws Exception{
		return placeholderrateService.getAll();
	}
	
	@RequestMapping("/getLastestByLibraryid.do")
	public Placeholderrate getLastestByLibraryid(Integer libraryId) throws Exception{
		return placeholderrateService.getLastestByLibraryid(libraryId);
	}
}
