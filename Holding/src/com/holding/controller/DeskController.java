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
import com.holding.service.DeskService;
import com.holding.vm.DeskChildListVm;

@RestController
@RequestMapping("/desk")
public class DeskController {

	@Autowired
	private DeskService deskService;
	
	@RequestMapping("/getDeskChildListVmListByroomId.do")
	private List<DeskChildListVm> getDeskChildListVmListByroomId(int roomId) {
		return deskService.getDeskChildlistVmListByroomId(roomId);
	}
	
	@RequestMapping("/insertDesk.do")
	public Map<String, Object> addDesk(Desk desk) throws SQLException{
		return deskService.insertDesk(desk);
	}
	
	@RequestMapping("/deleteSeat.do")
	public Map<String, Object> removeSeat(@RequestParam(required=false) int...deskIds) throws SQLException{
		List<Integer> ids = new ArrayList<>();
		for (int deskId : deskIds) {
			ids.add(deskId);
		}
		return deskService.deleteDesk(ids);
	}
	
	@RequestMapping("/updateDesk.do")
	public Map<String, Object> updateSeat(Desk desk) throws SQLException{
		return deskService.updateDesk(desk);
	}
	
}
