package com.holding.vm;

import com.holding.po.Desk;
import com.holding.po.Seat;

public class DeskChildVm extends Desk{

	private Seat seat;

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	
	
}
