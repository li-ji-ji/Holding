package com.holding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.holding.service.DeskService;
import com.holding.vm.DeskCListVm;

@RestController
@RequestMapping("/desk")
public class DeskController {

	@Autowired
	private DeskService deskService;
	
	@RequestMapping("/getDeskCListVmListByroomId.do")
	private List<DeskCListVm> getDeskCListVmListByroomId(int roomId) {
		return deskService.getDeskCListVmListByroomId(roomId);
	}
}
