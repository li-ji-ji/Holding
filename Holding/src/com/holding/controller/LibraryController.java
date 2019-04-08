package com.holding.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.holding.po.Library;
import com.holding.service.LibraryService;
import com.holding.vm.LibraryVm;
import com.sun.javafx.collections.MappingChange.Map;

@RestController
@RequestMapping("/library")
public class LibraryController {

	@Autowired
	private LibraryService libraryService;
	
	//通过区域获取图书馆列表
	@RequestMapping("/getLibraryList.do")
	public List<Library> getLibraryList(int provinceId, int cityId) {
		return libraryService.getLibraryList(provinceId, cityId);
	}
	
	//根据定位到位置信息
	@RequestMapping("/getLibraryVm.do")
	public LibraryVm getLibraryVm(int libraryId, int floorId, int roomId, int deskId, int seatId) {
		return libraryService.getLibraryVmById(libraryId, floorId, roomId, deskId, seatId);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/insertLibrary.do")
	public Map<String, Object> addLibrary(Library library) throws SQLException{
		return (Map<String, Object>) libraryService.insertLibrary(library);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/deleteLibrary.do")
	public Map<String, Object> removeLibrary(int...libraryIds) throws SQLException{
		List<Integer> ids = new ArrayList<>();
		for (int libraryId : libraryIds) {
			ids.add(libraryId);
		}
		return (Map<String, Object>) libraryService.deleteLibrary(ids);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/updateLibrary.do")
	public Map<String, Object> updateLibrary(Library library) throws SQLException{
		return (Map<String, Object>) libraryService.updateLibrary(library);
	}
	
}
