package com.apisuite.MyWeatherAPI;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("weatherAPI")
public class WeatherAPIMasterSuite {
	
	WeatherDatabaseHandler myWeatherDatabaseHandler = new WeatherDatabaseHandler();
	
	//GET - Fetch all cities data
	@GET
	@Path("fetchAllCityData")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<WeatherData> getWeatherData() {
	
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
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public WeatherData addWeatherRecordData(WeatherData aWeatherData) {
		
		System.out.println(aWeatherData);
		
		myWeatherDatabaseHandler.addWeatherRecordData(aWeatherData);
		return aWeatherData;
	}
	
	//PUT - Update one record
	@PUT
	@Path("updateWeatherRecordData")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public WeatherData modifyWeatherRecordData(WeatherData aWeatherData) {
			
		System.out.println(aWeatherData);
			
		myWeatherDatabaseHandler.modifyWeatherRecordData(aWeatherData);
		return aWeatherData;
	}
	
	//DELETE - Delete one record based on id
	@DELETE
	@Path("removeWeatherDataById/{id}")
	public WeatherData removeWeatherDataById(@PathParam("id") int aIdToRemove) {
		WeatherData myWeatherData = myWeatherDatabaseHandler.getOneRecordData(aIdToRemove);
		
		myWeatherDatabaseHandler.removeOneRecordData(aIdToRemove);
		
		return myWeatherData;
	}
	
}
