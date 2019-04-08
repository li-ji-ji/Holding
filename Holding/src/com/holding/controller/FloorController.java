package com.holding.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.holding.po.Floor;
import com.holding.service.FloorService;
import com.holding.vm.FloorCListVm;
@CrossOrigin
@RestController
@RequestMapping("/floor")
public class FloorController {

	@Autowired
	private FloorService floorService;
	
	@RequestMapping("/getFloorCListVmListByLibraryId.do")
	public List<FloorCListVm> getFloorCListVmListByLibraryId(int libraryId){
		return floorService.getFloorCListVmListByLibraryId(libraryId);
	}
	
	
	@RequestMapping("/insertFloor.do")
	public Map<String, Object> addFloor(Floor floor) throws SQLException{
		return floorService.insertFloor(floor);
	}
	
	@RequestMapping("/deleteFloor.do")
	public Map<String, Object> removeFloor(int...floorIds) throws SQLException{
		List<Integer> ids = new ArrayList<>();
		for (int floorId : floorIds) {
			ids.add(floorId);
		}
		return floorService.deleteFloor(ids);
	}
	
	@RequestMapping("/updateFloor.do")
	public Map<String, Object> updateFloor(Floor floor) throws SQLException{
		return floorService.updateFloor(floor);
	}
	
}
