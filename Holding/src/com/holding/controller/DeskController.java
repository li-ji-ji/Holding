package com.holding.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.holding.po.Desk;
import com.holding.service.DeskService;
import com.holding.vm.DeskCListVm;

@CrossOrigin
@RestController
@RequestMapping("/desk")
public class DeskController {

	@Autowired
	private DeskService deskService;
	
	@RequestMapping("/getDeskCListVmListByroomId.do")
	private List<DeskCListVm> getDeskCListVmListByroomId(int roomId) {
		return deskService.getDeskCListVmListByroomId(roomId);
	}
	
	@RequestMapping("/insertDesk.do")
	public Map<String, Object> adddesk(Desk desk) throws SQLException{
		return deskService.insertDesk(desk);
	}
	
	@RequestMapping("/deleteDesk.do")
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
