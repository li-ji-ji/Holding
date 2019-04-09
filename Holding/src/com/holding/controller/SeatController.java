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

import com.holding.po.Seat;
import com.holding.service.SeatService;

@CrossOrigin
@RestController
@RequestMapping("seat")
public class SeatController {

	@Autowired
	public SeatService seatService;
	
	@RequestMapping("/insertSeat.do")
	public Map<String, Object> addSeat(Seat seat) throws SQLException{
		return seatService.insertSeat(seat);
	}
	
	@RequestMapping("/deleteSeat.do")
	public Map<String, Object> removeSeat(@RequestParam(required=false) int...seatIds) throws SQLException{
		List<Integer> ids = new ArrayList<>();
		for (int seatId : seatIds) {
			ids.add(seatId);
		}
		return seatService.deleteSeatById(ids);
	}
	
	@RequestMapping("/updateSeat.do")
	public Map<String, Object> updateSeat(Seat seat) throws SQLException{
		return seatService.updateSeat(seat);
	}
}
