package com.holding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.holding.service.FloorService;
import com.holding.vm.FloorChildListVm;
import com.holding.vm.FloorChildPercentagelistVm;

@RestController
@RequestMapping("/floor")
public class FloorController {

	@Autowired
	private FloorService floorService;
	
	@RequestMapping("/getFloorChildListVmListByLibraryId.do")
	public List<FloorChildListVm> getFloorChildListVmListByLibraryId(int libraryId){
		return floorService.getFloorChildListVmlistByLibraryId(libraryId);
	}
	
	@RequestMapping("/getFloorChildPercentagelistVmListByLibraryId.do")
	public List<FloorChildPercentagelistVm> getFloorChildPercentagelistVmListByLibraryId(int libraryId){
		return floorService.getFloorChildPercentagelistVmListByLibraryId(libraryId);
	}
	
}
