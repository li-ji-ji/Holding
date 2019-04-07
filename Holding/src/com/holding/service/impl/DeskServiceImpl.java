package com.holding.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.holding.mapper.DeskMapper;
import com.holding.po.Desk;
import com.holding.po.DeskExample;
import com.holding.po.Seat;
import com.holding.service.DeskService;
import com.holding.service.SeatService;
import com.holding.vm.DeskCListVm;
import com.holding.vm.DeskVm;

@Service
@Transactional
public class DeskServiceImpl implements DeskService {

	@Autowired
	private DeskMapper deskMapper;
	@Autowired
	private SeatService seatService;
	
	@Override
	public List<DeskCListVm> getDeskVmList(int roomId) {
		DeskExample deskExample = new DeskExample();
		DeskExample.Criteria dCriteria = deskExample.createCriteria();
		dCriteria.andRoomidEqualTo(roomId);
		List<Desk> desks = deskMapper.selectByExample(deskExample);
		List<DeskCListVm> deskVms = new ArrayList<>();
		for (Desk desk : desks) {
			DeskCListVm deskVm = new DeskCListVm();
			deskVm.setId(desk.getId());
			deskVm.setName(desk.getName());
			deskVm.setHeight(desk.getHeight());
			deskVm.setWidth(desk.getWidth());
			deskVm.setXmaxnum(desk.getXmaxnum());
			deskVm.setYmaxnum(desk.getYmaxnum());
			deskVm.setXaxis(desk.getXaxis());
			deskVm.setYaxis(desk.getYaxis());
			deskVm.setRoomid(desk.getRoomid());
			deskVm.setStatus(desk.getStatus());
			List<Seat> seats = seatService.getSeatListBydeskId(desk.getId());
			deskVm.setSeat(seats);
			deskVms.add(deskVm);
		}
		return deskVms;
	}

	@Override
	public DeskVm getDeskVmById(int deskId,int seatId) {
		DeskVm deskVm = new DeskVm();
		Desk desk = deskMapper.selectByPrimaryKey(deskId);
		Seat seat = seatService.getSeatById(seatId);
		deskVm.setSeat(seat);
		deskVm.setId(desk.getId());
		//...װ���װ��
		return deskVm;
	}

	
	
	@Override
	public void insertDesk(Desk desk) throws SQLException {
		try {
			deskMapper.insert(desk);
		} catch (Exception e) {
			throw new SQLException("添加失败");
		}
	}
	
	@Override
	public void deleteDesk(List<Integer> deskIds) throws SQLException {
		for (int deskId : deskIds) {
			try {
				List<Seat> seats = seatService.getSeatListBydeskId(deskId);
				List<Integer> seatIds = new ArrayList<>();
				for (Seat seat : seats) {
					seatIds.add(seat.getId());
				}
				seatService.deleteSeatById(seatIds);
				deskMapper.deleteByPrimaryKey(deskId);
			} catch (Exception e) {
				throw new SQLException("删除失败");
			}
		}
	}

	@Override
	public void updateDesk(Desk desk) throws SQLException {
		try {
			deskMapper.updateByPrimaryKeySelective(desk);
		} catch (Exception e) {
			throw new SQLException("修改失败");
		}
	}

	@Override
	public List<Desk> getDeskListByRoomId(int roomId) {
		DeskExample deskExample = new DeskExample();
		DeskExample.Criteria dCriteria = deskExample.createCriteria();
		dCriteria.andRoomidEqualTo(roomId);
		return deskMapper.selectByExample(deskExample);
	}

}
