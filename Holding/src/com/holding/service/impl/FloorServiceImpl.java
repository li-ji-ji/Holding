package com.holding.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holding.mapper.FloorMapper;
import com.holding.po.Floor;
import com.holding.po.FloorExample;
import com.holding.po.Room;
import com.holding.service.FloorService;
import com.holding.service.RoomService;
import com.holding.vm.FloorCListVm;
import com.holding.vm.FloorVm;
import com.holding.vm.RoomVm;

@Service
public class FloorServiceImpl implements FloorService {

	@Autowired
	private FloorMapper floorMapper;
	@Autowired
	private RoomService roomService;
	
	
	@Override
	public List<FloorCListVm> getFloorCListVmListByLibraryId(int libraryId) {
		FloorExample floorExample = new FloorExample();
		FloorExample.Criteria fcriteria = floorExample.createCriteria();
		fcriteria.andLibraryidEqualTo(libraryId);
		List<Floor> floors = floorMapper.selectByExample(floorExample);
		List<FloorCListVm> floorVms = new ArrayList<>();
		for (Floor floor : floors) {
			FloorCListVm floorVm = new FloorCListVm();
			floorVm.setId(floor.getId());
			floorVm.setLibraryid(floor.getLibraryid());
			floorVm.setName(floor.getName());
			floorVm.setStatus(floor.getStatus());
			List<Room> rooms = roomService.getRoomListByFloorId(floor.getId());
			floorVm.setRooms(rooms);
			floorVms.add(floorVm);
		}
		return floorVms;
	}
	
	@Override
	public FloorVm getFloorVmById(int floorId, int roomId, int deskId, int seatId) {
		FloorVm floorVm = new FloorVm();
		RoomVm roomVm = roomService.getRoomVmById(roomId, deskId, seatId);
		floorVm.setRoomVm(roomVm);
		Floor floor = new Floor();
		floorVm.setId(floor.getId());
		return floorVm;
	}

	@Override
	public void insertFloor(Floor floor) throws SQLException {
		try {
			floorMapper.insertSelective(floor);
		} catch (Exception e) {
			throw new SQLException("添加失败");
		}
	}

	@Override
	public void deleteFloor(List<Integer> floorIds) throws SQLException {
		for (int floorId : floorIds) {
			try {
				List<Room> rooms = roomService.getRoomListByFloorId(floorId);
				List<Integer> roomIds = new ArrayList<>();
				for (Room room : rooms) {
					roomIds.add(room.getId());
				}
				roomService.deleteRoom(roomIds);
				floorMapper.deleteByPrimaryKey(floorId);
			} catch (Exception e) {
				throw new SQLException("删除失败");
			}
		}
	}

	@Override
	public void updateFloor(Floor floor) throws SQLException {
		try {
			floorMapper.updateByPrimaryKeySelective(floor);
		} catch (Exception e) {
			throw new SQLException("修改失败");
		}
	}

	@Override
	public List<Floor> getFloorListBylibraryId(int libraryId) {
		FloorExample floorExample = new FloorExample();
		FloorExample.Criteria fCriteria = floorExample.createCriteria();
		fCriteria.andLibraryidEqualTo(libraryId);
		return floorMapper.selectByExample(floorExample);
	}
	
	
	

}
