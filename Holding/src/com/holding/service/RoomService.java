package com.holding.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.holding.po.Room;
import com.holding.vm.RoomVm;

@Service
public interface RoomService {

	public List<Room> getRoomListByFloorId(int floorId);
	
	public RoomVm getRoomVmById(int roomId,int deskId,int seatId);
	
	public void insertRoom(Room room) throws SQLException;
	
	public void deleteRoom(List<Integer> roomIds) throws SQLException;
	
	public void updateRoom(Room room) throws SQLException;
}
