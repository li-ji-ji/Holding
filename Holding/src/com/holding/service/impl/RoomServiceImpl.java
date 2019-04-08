package com.holding.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holding.mapper.RoomMapper;
import com.holding.po.Desk;
import com.holding.po.Room;
import com.holding.po.RoomExample;
import com.holding.service.DeskService;
import com.holding.service.RoomService;
import com.holding.vm.DeskVm;
import com.holding.vm.RoomVm;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomMapper roomMapper;
	
	@Override
	public List<Room> getRoomListByFloorId(int floorId) {
		RoomExample roomExample = new RoomExample();
		RoomExample.Criteria rCriteria = roomExample.createCriteria();
		rCriteria.andFlooridEqualTo(floorId);
		return roomMapper.selectByExample(roomExample);
	}

	@Autowired
	private DeskService deskService;
	
	@Override
	public RoomVm getRoomVmById(int roomId, int deskId, int seatId) {
		RoomVm roomVm = new RoomVm();
		DeskVm deskVm = deskService.getDeskVmById(deskId, seatId);
		roomVm.setDeskVm(deskVm);
		Room room = roomMapper.selectByPrimaryKey(roomId);
		roomVm.setId(room.getId());
		roomVm.setFloorid(room.getFloorid());
		roomVm.setImageurl(room.getImageurl());
		roomVm.setName(room.getName());
		roomVm.setStatus(room.getStatus());
		return roomVm;
	}
	
	@Override
	public Map<String, Object> insertRoom(Room room) throws SQLException {
		Map<String, Object> msg = new HashMap<>();
		try {
			roomMapper.insertSelective(room);
			msg.put("success", true);
			msg.put("msg", "添加成功");
		} catch (Exception e) {
			msg.put("success", false);
			msg.put("msg", "添加失败");
		}
		return msg;
	}

	@Override
	public Map<String, Object> deleteRoom(List<Integer> roomIds) throws SQLException {
		Map<String, Object> msg = new HashMap<>();
		for (int roomId : roomIds) {
			try {
				List<Desk> desks = deskService.getDeskListByRoomId(roomId);
				List<Integer> deskIds = new ArrayList<>();
				for (Desk desk : desks) {
					deskIds.add(desk.getId());
				}
				deskService.deleteDesk(deskIds);
				roomMapper.deleteByPrimaryKey(roomId);
				msg.put("success", true);
				msg.put("msg", "删除成功");
			} catch (Exception e) {
				msg.put("success", false);
				msg.put("msg", "删除失败");
			}
		}
		return msg;
	}

	@Override
	public Map<String, Object> updateRoom(Room room) throws SQLException {
		Map<String, Object> msg = new HashMap<>();
		try {
			roomMapper.updateByPrimaryKeySelective(room);
			msg.put("success", true);
			msg.put("msg", "修改成功");
		} catch (Exception e) {
			msg.put("success", false);
			msg.put("msg", "修改失败");
		}
		return msg;
	}

}
