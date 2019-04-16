package com.holding.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.holding.po.Desk;
import com.holding.po.Floor;
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
	
	@RequestMapping("/insertDesk.do")
	public Map<String, Object> addFloor(Floor floor) throws SQLException{
		return floorService.insertFloor(floor);
	}
	
	@RequestMapping("/deleteFloor.do")
	public Map<String, Object> removeFloor(@RequestParam(required=false) int...floorIds) throws SQLException{
		List<Integer> ids = new ArrayList<>();
		for (int floorId : floorIds) {
			ids.add(floorId);
		}
		return floorService.deleteFloor(ids);
	}
	
	@RequestMapping("/updateDesk.do")
	public Map<String, Object> updateFloor(Floor floor) throws SQLException{
		return floorService.updateFloor(floor);
	}
	
}
