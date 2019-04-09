package com.holding.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holding.mapper.LibraryMapper;
import com.holding.po.Floor;
import com.holding.po.Library;
import com.holding.po.LibraryExample;
import com.holding.service.FloorService;
import com.holding.service.LibraryService;
import com.holding.vm.FloorVm;
import com.holding.vm.LibraryVm;

@Service
public class LibraryServiceImpl implements LibraryService{

	@Autowired
	private LibraryMapper libraryMapper;

	@Override
	public List<Library> getLibraryList(int provinceId, int cityId) {
		LibraryExample libraryExample = new LibraryExample();
		LibraryExample.Criteria criteria = libraryExample.createCriteria();
		criteria.andProvinceidEqualTo(provinceId);
		criteria.andCityidEqualTo(cityId);
		return libraryMapper.selectByExample(libraryExample);
	}

	@Autowired
	private FloorService floorService;
	
	
	@Override
	public LibraryVm getLibraryVmById(int libraryId, int floorId, int roomId, int deskId, int seatId) {
		LibraryVm libraryVm = new LibraryVm();
		FloorVm floorVm = floorService.getFloorVmById(floorId, roomId, deskId, seatId);
		libraryVm.setFloorVm(floorVm);
		Library library = libraryMapper.selectByPrimaryKey(libraryId);
		libraryVm.setId(library.getId());
		libraryVm.setImageurl(library.getImageurl());
		libraryVm.setAddress(library.getAddress());
		libraryVm.setCityid(library.getCityid());
		libraryVm.setLatitude(library.getLatitude());
		libraryVm.setLongitude(library.getLongitude());
		libraryVm.setStarttime(library.getStarttime());
		libraryVm.setEndtime(library.getEndtime());
		libraryVm.setProvinceid(library.getProvinceid());
		libraryVm.setStatus(library.getStatus());
		return libraryVm;
	}

	@Override
	public Map<String, Object> insertLibrary(Library library) throws SQLException {
		Map<String, Object> msg = new HashMap<>();
		try {
			libraryMapper.insertSelective(library);
			msg.put("success", true);
			msg.put("msg", "添加成功");
		} catch (Exception e) {
			msg.put("success", false);
			msg.put("msg", "添加失败");
		}
		return msg;
	}

	@Override
	public Map<String, Object> deleteLibrary(List<Integer> libraryIds) throws SQLException {
		Map<String, Object> msg = new HashMap<>();
		for (int libraryId : libraryIds) {
			try {
				List<Floor> floors = floorService.getFloorListBylibraryId(libraryId);
				List<Integer> floorIds = new ArrayList<>();
				for (Floor floor : floors) {
					floorIds.add(floor.getId());
				}
				floorService.deleteFloor(floorIds);
				libraryMapper.deleteByPrimaryKey(libraryId);
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
	public Map<String, Object> updateLibrary(Library library) throws SQLException {
		Map<String, Object> msg = new HashMap<>();
		try {
			libraryMapper.updateByPrimaryKeySelective(library);
			msg.put("success", true);
			msg.put("msg", "修改成功");
		} catch (Exception e) {
			msg.put("success", false);
			msg.put("msg", "修改失败");
		}
		return msg;
	}
	
	
	
}
