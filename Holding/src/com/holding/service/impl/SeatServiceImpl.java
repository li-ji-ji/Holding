package com.holding.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holding.mapper.SeatMapper;
import com.holding.po.Seat;
import com.holding.po.SeatExample;
import com.holding.service.SeatService;

@Service
public class SeatServiceImpl implements SeatService {

	@Autowired
	private SeatMapper seatMapper;
	
	@Override
	public List<Seat> getSeatlistBydeskId(int deskId) {
		SeatExample seatExample = new SeatExample();
		SeatExample.Criteria sCriteria = seatExample.createCriteria();
		sCriteria.andDeskidEqualTo(deskId);
		return seatMapper.selectByExample(seatExample);
	}

	@Override
	public Seat getSeatById(int seatId) {
		return seatMapper.selectByPrimaryKey(seatId);
	}

	@Override
	public Map<String, Object> insertSeat(Seat seat)  throws SQLException{
		Map<String, Object> msg = new HashMap<>();
		try {
			seatMapper.insert(seat);
			msg.put("success", true);
			msg.put("msg", "添加成功");
		} catch (Exception e) {
			msg.put("success", false);
			msg.put("msg", "添加失败");
		}
		return msg;
	}

	@Override
	public Map<String, Object> deleteSeatById(List<Integer> seatIds)throws SQLException {
		Map<String, Object> msg = new HashMap<>();
		for (int seatId : seatIds) {
			try {
				seatMapper.deleteByPrimaryKey(seatId);
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
	public Map<String, Object> updateSeat(Seat seat) throws SQLException{
		Map<String, Object> msg = new HashMap<>();
		try {
			seatMapper.updateByPrimaryKey(seat);
			msg.put("success", true);
			msg.put("msg", "修改成功");
		} catch (Exception e) {
			msg.put("success", false);
			msg.put("msg", "修改失败");
		}
		return msg;
	}

}
