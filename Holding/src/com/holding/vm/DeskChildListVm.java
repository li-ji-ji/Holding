package com.holding.vm;

import java.util.List;

import com.holding.po.Desk;
import com.holding.po.Seat;

public class DeskChildListVm extends Desk{

	private List<Seat> seat;

	public List<Seat> getSeat() {
		return seat;
	}

	public void setSeat(List<Seat> seat) {
		this.seat = seat;
	}
	
}
