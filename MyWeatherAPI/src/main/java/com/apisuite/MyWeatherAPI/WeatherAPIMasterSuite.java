package com.apisuite.MyWeatherAPI;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.*;

@Path("weatherAPI")
public class WeatherAPIMasterSuite {
	
	WeatherDatabaseHandler myWeatherDatabaseHandler = new WeatherDatabaseHandler();
	
	//GET - Fetch all cities data
	@GET
	@Path("fetchAllCityData")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<WeatherData> getWeatherData() {
		
		System.out.println("Entered getWeatherData");
	
		//Return the list
		return myWeatherDatabaseHandler.fetchAllWeatherData();
	}
	
	//GET - Fetch for one city based on id
	@GET
	@Path("getWeatherDataById/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public WeatherData getWeatherDataById(@PathParam("id") int aIdToFetch) {
		return myWeatherDatabaseHandler.getOneRecordData(aIdToFetch);
	}
	
	//GET - Fetch extreme weather data
	@GET
	@Path("getExtremeWeatherData")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public WeatherData fetchExtremeWeatherData() {
		return myWeatherDatabaseHandler.fetchExtremeWeatherData();
	}
	
	//POST - Add one record
	@POST
	@Path("addWeatherRecordData")
	public WeatherData addWeatherRecordData(WeatherData aWeatherData) {
		
		System.out.println(aWeatherData);
		
		myWeatherDatabaseHandler.addWeatherRecordData(aWeatherData);
		return aWeatherData;
	}
	
}
