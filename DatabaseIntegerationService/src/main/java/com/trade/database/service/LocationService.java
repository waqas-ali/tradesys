package com.trade.database.service;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trade.database.dao.LocationDAO;
import com.trade.database.pojo.Location;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/location")
public class LocationService {
	@Autowired
	  private LocationDAO dao;
	
	@RequestMapping(value="/addlocation",method=RequestMethod.POST)
	@ApiOperation(value = "Add new Location ", notes = "Add new Location")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 201, message = "") })
	public Location addLocation() {
		Location loc = new Location();
		loc.setLocationName("Islamabad");
		loc.setCreateddate(new Date());
		loc.setCreatedby("1");
		dao.create(loc);
		return loc;
	}
	@RequestMapping(value = "/getlocations", method=RequestMethod.GET)
	public Location getLocations() {
		Location loc = new Location();
		loc.setLocationName("Islamabad");
		loc.setCreateddate(new Date());
		loc.setCreatedby("1");
		return loc;
	}
}
