package com.svtech.hms.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svtech.hms.booking.dao.BookingDao;
import com.svtech.hms.booking.vo.HotelInventoryVO;

@Service("testService")
public class TestServiceImpl implements TestService {
	
	@Autowired
	BookingDao bookingDao;

	public HotelInventoryVO getRooms() {
		
		return bookingDao.getInv("ROOM1");
		
	}

	public String createBooking(HotelInventoryVO hotelInventoryVO) {
		
		bookingDao.createInventory(hotelInventoryVO);
		
		return "Created";
	}
	
	

}
