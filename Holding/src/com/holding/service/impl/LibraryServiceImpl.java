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
import com.holding.service.PlaceholderrateService;
import com.holding.vm.FloorChildVm;
import com.holding.vm.LibraryPercentageVm;
import com.holding.vm.LibraryChildVm;

@Service
public class LibraryServiceImpl implements LibraryService{

	@Autowired
	private LibraryMapper libraryMapper;

	@Autowired
	private PlaceholderrateService placeholderrateService;
	
	//通过区域获取包含占座率的图书馆列表
	@Override
	public List<LibraryPercentageVm> getLibraryPercentageVmList(int provinceId, int cityId) throws Exception {
		List<LibraryPercentageVm> libraryPercentageVms = new ArrayList<>();
		LibraryExample libraryExample = new LibraryExample();
		LibraryExample.Criteria criteria = libraryExample.createCriteria();
		criteria.andProvinceidEqualTo(provinceId);
		criteria.andCityidEqualTo(cityId);
		List<Library> libraries = libraryMapper.selectByExample(libraryExample);
		for (Library library : libraries) {
			LibraryPercentageVm libraryPercentageVm = new LibraryPercentageVm();
			libraryPercentageVm.setId(library.getId());
			libraryPercentageVm.setAddress(library.getAddress());
			libraryPercentageVm.setCityid(library.getCityid());
			libraryPercentageVm.setProvinceid(library.getProvinceid());
			libraryPercentageVm.setEndtime(library.getEndtime());
			libraryPercentageVm.setStarttime(library.getStarttime());
			libraryPercentageVm.setImageurl(library.getImageurl());
			libraryPercentageVm.setLatitude(library.getLatitude());
			libraryPercentageVm.setLongitude(library.getLongitude());
			libraryPercentageVm.setStatus(library.getStatus());
			libraryPercentageVm.setPercentage(placeholderrateService.getLastestByLibraryid(library.getId()).getLlibraryrate());
			libraryPercentageVms.add(libraryPercentageVm);
		}
		return libraryPercentageVms;
	}
	
	@Autowired
	private FloorService floorService;
	
	//定位座位
	@Override
	public LibraryChildVm getLibraryVmById(int libraryId, int floorId, int roomId, int deskId, int seatId) {
		LibraryChildVm libraryVm = new LibraryChildVm();
		FloorChildVm floorVm = floorService.getFloorVmById(floorId, roomId, deskId, seatId);
		libraryVm.setFloorVm(floorVm);
		Library library = libraryMapper.selectByPrimaryKey(libraryId);
		libraryVm.setId(library.getId());
		libraryVm.setAddress(library.getAddress());
		libraryVm.setCityid(library.getCityid());
		libraryVm.setProvinceid(library.getProvinceid());
		libraryVm.setEndtime(library.getEndtime());
		libraryVm.setStarttime(library.getStarttime());
		libraryVm.setImageurl(library.getImageurl());
		libraryVm.setLatitude(library.getLatitude());
		libraryVm.setLongitude(library.getLongitude());
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
				msg.put("msg", "添加成功");
			} catch (Exception e) {
				msg.put("success", false);
				msg.put("msg", "添加失败");
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
			msg.put("msg", "添加成功");
		} catch (Exception e) {
			msg.put("success", false);
			msg.put("msg", "添加失败");
		}
		return msg;
	}

	
	
	
	
}
