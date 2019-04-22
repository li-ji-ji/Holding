package com.holding.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.holding.po.Room;
import com.holding.vm.RoomChildVm;
import com.holding.vm.RoomPercentageVm;

@Service
public interface RoomService {

	public List<Room> getRoomlistByFloorId(int floorId);
	
	public List<RoomPercentageVm> getRoomPercentageVm(int floorId) throws Exception;
	
	public RoomChildVm getRoomChildVmById(int roomId,int deskId,int seatId);
	
	public Map<String, Object> insertRoom(Room room) throws SQLException;
	
	public Map<String, Object> deleteRoom(List<Integer> roomIds) throws SQLException;
	
	public Map<String, Object> updateRoom(Room room) throws SQLException;
}
