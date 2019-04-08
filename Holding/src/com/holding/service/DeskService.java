package com.holding.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.holding.po.Desk;
import com.holding.vm.DeskCListVm;
import com.holding.vm.DeskVm;

@Service
public interface DeskService {

	public List<DeskCListVm> getDeskCListVmListByroomId(int roomId);
	
	public DeskVm getDeskVmById(int deskId,int seatId);
	
	public List<Desk> getDeskListByRoomId(int roomId);
	
	public void insertDesk(Desk desk) throws SQLException;
	
	public void deleteDesk(List<Integer> deskIds) throws SQLException;
	
	public void updateDesk(Desk desk) throws SQLException;
}
