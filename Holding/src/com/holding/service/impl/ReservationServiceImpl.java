package com.holding.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holding.mapper.ReservationMapper;
import com.holding.po.Reservation;
import com.holding.service.ReservationService;



@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private ReservationMapper reservationMapper;
	
	@Override
	public List<Reservation> getAll() throws Exception {
		// TODO Auto-generated method stub
		return reservationMapper.selectByExample(null);
	}

}
