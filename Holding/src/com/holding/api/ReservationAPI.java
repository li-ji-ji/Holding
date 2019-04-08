package com.holding.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.holding.po.Reservation;
import com.holding.po.ResultMsg;
import com.holding.service.ReservationService;

@CrossOrigin
@RestController
@RequestMapping("/api/reservation")
public class ReservationAPI {

	@Autowired ReservationService reservationService;
	
	@RequestMapping("/index.do")
	public ResultMsg menu() {
		ResultMsg msg=new ResultMsg();
		msg.setCode("100");
		msg.setMsg("接口调用成功");
		return msg;
	}
	@RequestMapping("/all.do")
	public List<Reservation> getAll()throws Exception{
		return reservationService.getAll();
	}
	
}
