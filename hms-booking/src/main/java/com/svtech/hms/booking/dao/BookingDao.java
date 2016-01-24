package com.svtech.hms.booking.dao;

import com.svtech.hms.booking.vo.HotelInventoryVO;

public interface BookingDao {
	
	public HotelInventoryVO getInv(String roomId);

}
