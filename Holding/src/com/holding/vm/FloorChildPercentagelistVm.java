package com.holding.vm;

import java.util.List;

import com.holding.po.Floor;

public class FloorChildPercentagelistVm extends Floor{

	private List<RoomPercentageVm> roomPercentageVms;

	public List<RoomPercentageVm> getRoomPercentageVms() {
		return roomPercentageVms;
	}

	public void setRoomPercentageVms(List<RoomPercentageVm> roomPercentageVms) {
		this.roomPercentageVms = roomPercentageVms;
	}
	
}
