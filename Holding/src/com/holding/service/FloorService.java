package com.holding.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.holding.po.Floor;
import com.holding.vm.FloorChildListVm;
import com.holding.vm.FloorChildPercentagelistVm;
import com.holding.vm.FloorChildVm;

@Service
public interface FloorService {

	public List<FloorChildListVm> getFloorChildListVmlistByLibraryId(int libraryId);
	
	public List<FloorChildPercentagelistVm> getFloorChildPercentagelistVmListByLibraryId(int libraryId);
	
	public FloorChildVm getFloorVmById(int floorId,int roomId,int deskId,int seatId);
	
	public List<Floor> getFloorListBylibraryId(int libraryId);

	public Map<String, Object> insertFloor(Floor floor) throws SQLException;
	
	public Map<String, Object> deleteFloor(List<Integer> floorIds) throws SQLException;
	
	public Map<String, Object> updateFloor(Floor floor) throws SQLException;	
}
