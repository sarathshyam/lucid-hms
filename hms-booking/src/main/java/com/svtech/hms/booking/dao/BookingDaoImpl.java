package com.svtech.hms.booking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.svtech.hms.booking.vo.HotelInventoryVO;

public class BookingDaoImpl implements BookingDao{
	
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

	public HotelInventoryVO getInv(String roomId) {
		String query = "select room_id, room_type from hms_hotel_inventory where ROOM_ID = ?";
		
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
         
        //using RowMapper anonymous class, we can create a separate RowMapper for reuse
        HotelInventoryVO hotelInventoryVO = jdbcTemplate.queryForObject(query, new Object[]{roomId}, new RowMapper<HotelInventoryVO>(){ 
            public HotelInventoryVO mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
            	HotelInventoryVO hotelInventoryVO = new HotelInventoryVO();
            	hotelInventoryVO.setRoomId(rs.getString("ROOM_ID"));
            	hotelInventoryVO.setRoomType(rs.getString("ROOM_TYPE"));
                return hotelInventoryVO;
            }});
         
        return hotelInventoryVO;
	}

}
