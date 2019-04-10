package com.holding.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.holding.po.Reservation;

@Service
public interface ReservationService {
	//查询所有数据
	List<Reservation> getAll()throws Exception;
	
	//根据id查询
	Reservation getReservationById(Integer id) throws Exception;
	
	//添加
	int addReservation(Reservation reservation) throws Exception;
	
	//删除
	int deleteReservationById(Integer id) throws Exception;
}
