package com.svtech.hms.booking.vo;

import java.io.Serializable;

public class HotelInventoryVO implements Serializable{
	
	private String roomId;
	private String roomType;
	
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	

}
