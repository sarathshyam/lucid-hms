package com.svtech.hms.booking.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/testService/")
@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.APPLICATION_FORM_URLENCODED, MediaType.TEXT_XML})
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.APPLICATION_FORM_URLENCODED, MediaType.TEXT_XML})
public interface TestService {
	
	@GET
	@Path("/test")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.APPLICATION_FORM_URLENCODED, MediaType.TEXT_XML})
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.APPLICATION_FORM_URLENCODED, MediaType.TEXT_XML})
	public String test();

}
