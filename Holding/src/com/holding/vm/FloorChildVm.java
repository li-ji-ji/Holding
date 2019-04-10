package com.holding.vm;

import com.holding.po.Floor;

public class FloorChildVm extends Floor{

	private RoomChildVm roomVm;

	public RoomChildVm getRoomVm() {
		return roomVm;
	}

	public void setRoomVm(RoomChildVm roomVm) {
		this.roomVm = roomVm;
	}
	
}
