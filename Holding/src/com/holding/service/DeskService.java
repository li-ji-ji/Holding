package com.holding.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.holding.po.Desk;
import com.holding.vm.DeskChildListVm;
import com.holding.vm.DeskChildVm;

@Service
public interface DeskService {

	public List<DeskChildListVm> getDeskChildlistVmListByroomId(int roomId);
	
	public DeskChildVm getDeskChildVmById(int deskId,int seatId);
	
	public List<Desk> getDesklistByRoomId(int roomId);
	
	public Map<String, Object> insertDesk(Desk desk) throws SQLException;
	
	public Map<String, Object> deleteDesk(List<Integer> deskIds) throws SQLException;
	
	public Map<String, Object> updateDesk(Desk desk) throws SQLException;
}
