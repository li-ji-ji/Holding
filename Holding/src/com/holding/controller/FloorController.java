package com.holding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.holding.service.FloorService;
import com.holding.vm.FloorCListVm;

@RestController
@RequestMapping("/floor")
public class FloorController {

	@Autowired
	private FloorService floorService;
	
	@RequestMapping("/getFloorCListVmListByLibraryId.do")
	public List<FloorCListVm> getFloorCListVmListByLibraryId(int libraryId){
		return floorService.getFloorCListVmListByLibraryId(libraryId);
	}
	
}
