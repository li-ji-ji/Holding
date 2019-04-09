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

import com.holding.po.Room;
import com.holding.service.RoomService;

@CrossOrigin
@RestController
@RequestMapping("/room")
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	@RequestMapping("/insertRoom.do")
	public Map<String, Object> addRoom(Room room) throws SQLException{
		return roomService.insertRoom(room);
	}
	
	@RequestMapping("/deleteRoom.do")
	public Map<String, Object> removeRoom(@RequestParam(required=false) int...roomIds) throws SQLException{
		List<Integer> ids = new ArrayList<>();
		for (int roomId : roomIds) {
			ids.add(roomId);
		}
		return roomService.deleteRoom(ids);
	}
	
	@RequestMapping("/updateRoom.do")
	public Map<String, Object> updateRoom(Room room) throws SQLException{
		return roomService.updateRoom(room);
	}
}
