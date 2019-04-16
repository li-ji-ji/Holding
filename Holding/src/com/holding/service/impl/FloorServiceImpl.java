package com.holding.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holding.mapper.FloorMapper;
import com.holding.po.Floor;
import com.holding.po.FloorExample;
import com.holding.po.Room;
import com.holding.service.FloorService;
import com.holding.service.RoomService;
import com.holding.vm.FloorChildListVm;
import com.holding.vm.FloorChildPercentagelistVm;
import com.holding.vm.FloorChildVm;
import com.holding.vm.RoomChildVm;
import com.holding.vm.RoomPercentageVm;

@Service
public class FloorServiceImpl implements FloorService {

	@Autowired
	private FloorMapper floorMapper;
	@Autowired
	private RoomService roomService;

	// 获取包含自习室列表的楼层列表
	@Override
	public List<FloorChildListVm> getFloorChildListVmlistByLibraryId(int libraryId) {
		FloorExample floorExample = new FloorExample();
		FloorExample.Criteria fcriteria = floorExample.createCriteria();
		fcriteria.andLibraryidEqualTo(libraryId);
		List<Floor> floors = floorMapper.selectByExample(floorExample);
		List<FloorChildListVm> floorVms = new ArrayList<>();
		for (Floor floor : floors) {
			FloorChildListVm floorVm = new FloorChildListVm();
			floorVm.setId(floor.getId());
			floorVm.setLibraryid(floor.getLibraryid());
			floorVm.setName(floor.getName());
			floorVm.setStatus(floor.getStatus());
			// 获取包含占座率的自习室包装类
			List<Room> rooms = roomService.getRoomlistByFloorId(floor.getId());
			floorVm.setRooms(rooms);
			floorVms.add(floorVm);
		}
		return floorVms;
	}

	// 获取包含自习室列表的楼层列表
	@Override
	public List<FloorChildPercentagelistVm> getFloorChildPercentagelistVmListByLibraryId(int libraryId) {
		List<Floor> floors = this.getFloorListBylibraryId(libraryId);
		List<FloorChildPercentagelistVm> floorVms = new ArrayList<>();
		for (Floor floor : floors) {
			FloorChildPercentagelistVm floorVm = new FloorChildPercentagelistVm();
			floorVm.setId(floor.getId());
			floorVm.setLibraryid(floor.getLibraryid());
			floorVm.setName(floor.getName());
			floorVm.setStatus(floor.getStatus());
			// 获取包含占座率的自习室包装类
			List<RoomPercentageVm> roomPercentageVms = roomService.getRoomPercentageVm(floor.getId());
			floorVm.setRoomPercentageVms(roomPercentageVms);
			floorVms.add(floorVm);
		}
		return floorVms;
	}

	// 定位座位
	@Override
	public FloorChildVm getFloorVmById(int floorId, int roomId, int deskId, int seatId) {
		FloorChildVm floorVm = new FloorChildVm();
		RoomChildVm roomVm = roomService.getRoomChildVmById(roomId, deskId, seatId);
		Floor floor = floorMapper.selectByPrimaryKey(floorId);
		floorVm.setRoomVm(roomVm);
		floorVm.setId(floor.getId());
		floorVm.setLibraryid(floor.getLibraryid());
		floorVm.setName(floor.getName());
		floorVm.setStatus(floor.getStatus());
		return floorVm;
	}

	@Override
	public Map<String, Object> insertFloor(Floor floor) throws SQLException {
		Map<String, Object> msg = new HashMap<>();
		try {
			floorMapper.insertSelective(floor);
			msg.put("success", true);
			msg.put("msg", "添加成功");
		} catch (Exception e) {
			msg.put("success", false);
			msg.put("msg", "添加失败");
		}
		return msg;
	}

	@Override
	public Map<String, Object> deleteFloor(List<Integer> floorIds) throws SQLException {
		Map<String, Object> msg = new HashMap<>();
		for (int floorId : floorIds) {
			try {
				List<Room> rooms = roomService.getRoomlistByFloorId(floorId);
				List<Integer> roomIds = new ArrayList<>();
				for (Room room : rooms) {
					roomIds.add(room.getId());
				}
				roomService.deleteRoom(roomIds);
				floorMapper.deleteByPrimaryKey(floorId);
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
	public Map<String, Object> updateFloor(Floor floor) throws SQLException {
		Map<String, Object> msg = new HashMap<>();
		try {
			floorMapper.updateByPrimaryKeySelective(floor);
			msg.put("success", true);
			msg.put("msg", "修改成功");
		} catch (Exception e) {
			msg.put("success", false);
			msg.put("msg", "修改失败");
		}
		return msg;
	}

	@Override
	public List<Floor> getFloorListBylibraryId(int libraryId) {
		FloorExample floorExample = new FloorExample();
		FloorExample.Criteria fCriteria = floorExample.createCriteria();
		fCriteria.andLibraryidEqualTo(libraryId);
		return floorMapper.selectByExample(floorExample);
	}

}
