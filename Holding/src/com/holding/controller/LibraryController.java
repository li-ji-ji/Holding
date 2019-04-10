package com.holding.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.holding.po.Library;
import com.holding.service.LibraryService;
import com.holding.vm.LibraryIncludePercentageVm;
import com.holding.vm.LibraryVm;
@CrossOrigin
@RestController
@RequestMapping("/library")
public class LibraryController {

	@Autowired
	private LibraryService libraryService;
	
	//通过区域获取图书馆列表(包含占座率)
	@RequestMapping("/getLibraryList.do")
	public List<LibraryIncludePercentageVm> LibraryIncludePercentageVm(int provinceId, int cityId) {
		return libraryService.getLibraryIncludePercentageVmList(provinceId, cityId);
	}
	
	//根据定位到位置信息
	@RequestMapping("/getLibraryVm.do")
	public LibraryVm getLibraryVm(int libraryId, int floorId, int roomId, int deskId, int seatId) {
		return libraryService.getLibraryVmById(libraryId, floorId, roomId, deskId, seatId);
	}
	
	@RequestMapping("/insertLibrary.do")
	public Map<String, Object> addLibrary(Library library) throws SQLException{
		return libraryService.insertLibrary(library);
	}
	
	@RequestMapping("/deleteLibrary.do")
	public Map<String, Object> removeLibrary(int...libraryIds) throws SQLException{
		List<Integer> ids = new ArrayList<>();
		for (int libraryId : libraryIds) {
			ids.add(libraryId);
		}
		return libraryService.deleteLibrary(ids);
	}
	
	@RequestMapping("/updateLibrary.do")
	public Map<String, Object> updateLibrary(Library library) throws SQLException{
		return libraryService.updateLibrary(library);
	}
	
}
