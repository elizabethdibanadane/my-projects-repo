package com.apisuite.MyWeatherAPI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WeatherDatabaseHandler {
	
	List<WeatherData> myWeatherDataList;
	
	private static final String myDatabaseURL = "jdbc:derby:weatherdb";
	Connection myDBConnection;

	/*******************************************************************************************
	 * Constructor
	 * 
	 * 
	 ********************************************************************************************/
	public WeatherDatabaseHandler() {
		
		try {
		myDBConnection = DriverManager.getConnection(myDatabaseURL);
		}
		catch (SQLException sqlException) {
			
		}
	}
	
	/*******************************************************************************************
	 * Retrieves the weather data for all cities from the table
	 * 
	 * 
	 ********************************************************************************************/
	public List<WeatherData> fetchAllWeatherData(){
		
		List<WeatherData> myWeatherDataList = new ArrayList<>();
		//select query
		String mySelectQuery = "select * from cities_weather";
		
		//Read from DB, loop through and populate the list
		try {
		Statement mySQLQueryStatement = myDBConnection.createStatement();
		
		ResultSet myResultSet = mySQLQueryStatement.executeQuery(mySelectQuery);
		
		while (myResultSet.next()) {
			WeatherData myWeatherData = new WeatherData();
			myWeatherData.setId(myResultSet.getInt(1));
			myWeatherData.setCity(myResultSet.getString(2));
			myWeatherData.setDate(myResultSet.getDate(3));
			myWeatherData.setTemperature(myResultSet.getLong(4));
			myWeatherData.setRain(myResultSet.getInt(5));
			myWeatherData.setWind(myResultSet.getInt(6));
			
			myWeatherDataList.add(myWeatherData);
		}
		}
		catch(SQLException mySQLException) {
			System.out.println(mySQLException);
		}
		return myWeatherDataList;
	}
	
	/*******************************************************************************************
	 * Retrieves weather data for a particular city based on id
	 * 
	 * 
	 ********************************************************************************************/
	public WeatherData getOneRecordData(int id) {
		
		//select query
		String mySelectQuery = "select * from cities_weather where id="+id;
		
		WeatherData myWeatherData = new WeatherData();
				
		//Read from DB, loop through and pick the record
		try {
			Statement mySQLQueryStatement = myDBConnection.createStatement();
				
			ResultSet myResultSet = mySQLQueryStatement.executeQuery(mySelectQuery);
				
			if (myResultSet.next()) {
				myWeatherData.setId(myResultSet.getInt(1));
				myWeatherData.setCity(myResultSet.getString(2));
				myWeatherData.setDate(myResultSet.getDate(3));
				myWeatherData.setTemperature(myResultSet.getLong(4));
				myWeatherData.setRain(myResultSet.getInt(5));
				myWeatherData.setWind(myResultSet.getInt(6));
			}
		}
		catch(SQLException mySQLException) {
					System.out.println(mySQLException);
		}
		
		return myWeatherData;
	}
	/*******************************************************************************************
	 * Retrieves the extreme weather data based on temperature
	 * 
	 * 
	 ********************************************************************************************/
	public WeatherData fetchExtremeWeatherData(){
		
		List<WeatherData> myWeatherDataList = new ArrayList<>();
		
		//Coolest
		WeatherData myCoolestWeatherData = new WeatherData();
		//Warmest
		WeatherData myWarmestWeatherData = new WeatherData();
		
		//select query
		String mySelectQuery = "select * from cities_weather";
		
		//Read from DB, loop through and populate the list
		try {
		Statement mySQLQueryStatement = myDBConnection.createStatement();
		
		ResultSet myResultSet = mySQLQueryStatement.executeQuery(mySelectQuery);
		
		while (myResultSet.next()) {
			WeatherData myWeatherData = new WeatherData();
			myWeatherData.setId(myResultSet.getInt(1));
			myWeatherData.setCity(myResultSet.getString(2));
			myWeatherData.setDate(myResultSet.getDate(3));
			myWeatherData.setTemperature(myResultSet.getLong(4));
			myWeatherData.setRain(myResultSet.getInt(5));
			myWeatherData.setWind(myResultSet.getInt(6));
			
			myWeatherDataList.add(myWeatherData);
		}
		
		myCoolestWeatherData.setTemperature(myWeatherDataList.get(1).getTemperature());
		
		//Find the coolest
		for(int i=0; i<myWeatherDataList.size(); i++) {
			WeatherData myWeatherData = myWeatherDataList.get(i);
			if(myWeatherData.getTemperature() < myCoolestWeatherData.getTemperature()) {
				myCoolestWeatherData = myWeatherData;
			}
			
			}
		}
		catch(SQLException mySQLException) {
			System.out.println(mySQLException);
		}
		return myCoolestWeatherData;
	}

	/*******************************************************************************************
	 * Adds a new weather record to the table
	 * 
	 * 
	 ********************************************************************************************/
	public void addWeatherRecordData(WeatherData aWeatherData) {
		
		//insert query
		String myInsertQuery = "insert into cities_weather (city,date,temperature,wind,rain) values (?,?,?,?,?)";
				
						
		try {
			PreparedStatement mySQLQueryStatement = myDBConnection.prepareStatement(myInsertQuery);
					
			//mySQLQueryStatement.setInt(1,myWeatherData.getId());
			mySQLQueryStatement.setString(1,aWeatherData.getCity());
			mySQLQueryStatement.setDate(2, new java.sql.Date((aWeatherData.getDate().getTime())));
			mySQLQueryStatement.setLong(3, aWeatherData.getTemperature());
			mySQLQueryStatement.setInt(4,aWeatherData.getWind());
			mySQLQueryStatement.setInt(5,aWeatherData.getRain());
			mySQLQueryStatement.executeUpdate();
						
			
		}
		catch(SQLException mySQLException) {
							System.out.println(mySQLException);
		}
		
	}
	/*******************************************************************************************
	 * Modifies a  weather record in the table
	 * 
	 * 
	 ********************************************************************************************/
	public void modifyWeatherRecordData(WeatherData aWeatherData) {
		//update query
		String myUpdateQuery = "update cities_weather set city=?,date=?,temperature=?,wind=?,rain=? where id=?";
						
								
		try {
			PreparedStatement mySQLQueryStatement = myDBConnection.prepareStatement(myUpdateQuery);
							
			mySQLQueryStatement.setString(1,aWeatherData.getCity());
			mySQLQueryStatement.setDate(2, new java.sql.Date((aWeatherData.getDate().getTime())));
			mySQLQueryStatement.setLong(3, aWeatherData.getTemperature());
			mySQLQueryStatement.setInt(4,aWeatherData.getWind());
			mySQLQueryStatement.setInt(5,aWeatherData.getRain());
			mySQLQueryStatement.setInt(6,aWeatherData.getId());
			mySQLQueryStatement.executeUpdate();
								
					
			}
			catch(SQLException mySQLException) {
				System.out.println(mySQLException);
			}
	}
	/*******************************************************************************************
	 * Removes a weather record in the table
	 * 
	 * 
	 ********************************************************************************************/
	public void removeOneRecordData(int aIdToRemove) {
		//delete query
		String myUpdateQuery = "delete from cities_weather where id=?";
								
										
		try {
			PreparedStatement mySQLQueryStatement = myDBConnection.prepareStatement(myUpdateQuery);
									
			mySQLQueryStatement.setInt(1,aIdToRemove);
			mySQLQueryStatement.executeUpdate();
										
							
			}
			catch(SQLException mySQLException) {
				System.out.println(mySQLException);
			}
	}
	

}
