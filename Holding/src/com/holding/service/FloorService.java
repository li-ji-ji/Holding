package com.holding.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.holding.po.Floor;
import com.holding.vm.FloorCListVm;
import com.holding.vm.FloorVm;

@Service
public interface FloorService {

	public List<FloorCListVm> getFloorCListVmListByLibraryId(int libraryId);
	
	public FloorVm getFloorVmById(int floorId,int roomId,int deskId,int seatId);
	
	public List<Floor> getFloorListBylibraryId(int libraryId);

	public Map<String, Object> insertFloor(Floor floor) throws SQLException;
	
	public Map<String, Object> deleteFloor(List<Integer> floorIds) throws SQLException;
	
	public Map<String, Object> updateFloor(Floor floor) throws SQLException;	
}
