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

	@Override
	public Reservation getReservationById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return  reservationMapper.selectByPrimaryKey(id);
	}

	@Override
	public int addReservation(Reservation reservation) throws Exception {
		try {
			reservationMapper.insertSelective(reservation);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("添加失败");
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteReservationById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		try {
			reservationMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("删除失败");
			return 1;
		}
		return 0;
	}

}
