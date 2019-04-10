package com.holding.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.holding.po.Reservation;

@Service
public interface ReservationService {
	//查询所有数据
	List<Reservation> getAll()throws Exception;
	
}
