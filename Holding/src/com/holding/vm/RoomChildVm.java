package com.holding.vm;

import com.holding.po.Room;

public class RoomChildVm extends Room{

	private DeskChildVm deskVm;

	public DeskChildVm getDeskVm() {
		return deskVm;
	}

	public void setDeskVm(DeskChildVm deskVm) {
		this.deskVm = deskVm;
	}
	
}
