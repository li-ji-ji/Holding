package com.holding.vm;

import java.util.List;

import com.holding.po.Floor;
import com.holding.po.Room;

public class FloorChildListVm extends Floor{

	private List<Room> rooms;

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
}
