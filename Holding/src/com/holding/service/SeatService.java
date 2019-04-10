package com.holding.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.holding.po.Seat;

@Service
public interface SeatService {

	public List<Seat> getSeatlistBydeskId(int deskId);
	
	public Seat getSeatById(int seatId);
	
	public Map<String, Object> insertSeat(Seat seat) throws SQLException;
	
	public Map<String, Object> deleteSeatById(List<Integer> seatIds) throws SQLException;
	
	public Map<String, Object> updateSeat(Seat seat) throws SQLException;
}
