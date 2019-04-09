package com.holding.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.holding.po.Desk;
import com.holding.vm.DeskCListVm;
import com.holding.vm.DeskVm;

@Service
public interface DeskService {

	public List<DeskCListVm> getDeskCListVmListByroomId(int roomId);
	
	public DeskVm getDeskVmById(int deskId,int seatId);
	
	public List<Desk> getDeskListByRoomId(int roomId);
	
	public Map<String, Object> insertDesk(Desk desk) throws SQLException;
	
	public Map<String, Object> deleteDesk(List<Integer> deskIds) throws SQLException;
	
	public Map<String, Object> updateDesk(Desk desk) throws SQLException;
}
