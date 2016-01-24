package com.svtech.hms.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svtech.hms.booking.dao.BookingDao;

@Service("testService")
public class TestServiceImpl implements TestService {
	
	@Autowired
	BookingDao bookingDao;

	public String test() {
		
		System.out.println(bookingDao.getInv("ROOM1"));
		
		return "Good to go";
	}
	
	

}
