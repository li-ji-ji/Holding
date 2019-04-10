package com.holding.service;

import java.sql.SQLException;
import java.util.List;

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

	public void insertFloor(Floor floor) throws SQLException;
	
	public void deleteFloor(List<Integer> floorIds) throws SQLException;
	
	public void updateFloor(Floor floor) throws SQLException;	
}
