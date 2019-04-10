package com.holding.vm;

import java.util.List;

import com.holding.po.Floor;

public class FloorIncludeChildPercentageListVm extends Floor{

	private List<RoomIncludePercentageVm> roomIncludePercentageVms;

	public List<RoomIncludePercentageVm> getRoomIncludePercentageVms() {
		return roomIncludePercentageVms;
	}

	public void setRoomIncludePercentageVms(List<RoomIncludePercentageVm> roomIncludePercentageVms) {
		this.roomIncludePercentageVms = roomIncludePercentageVms;
	}

	
}
