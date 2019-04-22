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
import com.holding.service.PlaceholderrateService;
import com.holding.service.RoomService;
import com.holding.vm.DeskChildVm;
import com.holding.vm.RoomChildVm;
import com.holding.vm.RoomPercentageVm;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomMapper roomMapper;
	
	@Autowired
	private PlaceholderrateService placeholderrateService;
	
	@Override
	public List<Room> getRoomlistByFloorId(int floorId) {
		RoomExample roomExample = new RoomExample();
		RoomExample.Criteria rCriteria = roomExample.createCriteria();
		rCriteria.andFlooridEqualTo(floorId);
		return roomMapper.selectByExample(roomExample);
	}

	@Override
	public List<RoomPercentageVm> getRoomPercentageVm(int floorId) throws Exception {
		List<RoomPercentageVm> roomPercentageVms = new ArrayList<>();
		List<Room> rooms = this.getRoomlistByFloorId(floorId);
		for (Room room : rooms) {
			RoomPercentageVm roomPercentageVm = new RoomPercentageVm();
			roomPercentageVm.setId(room.getId());
			roomPercentageVm.setFloorid(room.getFloorid());
			roomPercentageVm.setName(room.getName());
			roomPercentageVm.setImageurl(room.getImageurl());
			roomPercentageVm.setStatus(room.getStatus());
			roomPercentageVm.setUsageQuantity(placeholderrateService.getLastestByRoomid(room.getId()).getRoomrate());
			roomPercentageVms.add(roomPercentageVm);
		}
		return roomPercentageVms;
	}
	
	@Autowired
	private DeskService deskService;
	
	//定位座位
	@Override
	public RoomChildVm getRoomChildVmById(int roomId, int deskId, int seatId) {
		RoomChildVm roomVm = new RoomChildVm();
		DeskChildVm deskVm = deskService.getDeskChildVmById(deskId, seatId);
		roomVm.setDeskVm(deskVm);
		Room room = roomMapper.selectByPrimaryKey(roomId);
		roomVm.setId(room.getId());
		roomVm.setFloorid(room.getFloorid());
		roomVm.setName(room.getName());
		roomVm.setImageurl(room.getImageurl());
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
				List<Desk> desks = deskService.getDesklistByRoomId(roomId);
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
