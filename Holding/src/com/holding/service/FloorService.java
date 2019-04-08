package com.holding.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.holding.po.Floor;
import com.holding.vm.FloorCListVm;
import com.holding.vm.FloorVm;

@Service
public interface FloorService {

	public List<FloorCListVm> getFloorCListVmListByLibraryId(int libraryId);
	
	public FloorVm getFloorVmById(int floorId,int roomId,int deskId,int seatId);
	
	public List<Floor> getFloorListBylibraryId(int libraryId);

	public void insertFloor(Floor floor) throws SQLException;
	
	public void deleteFloor(List<Integer> floorIds) throws SQLException;
	
	public void updateFloor(Floor floor) throws SQLException;	
}
