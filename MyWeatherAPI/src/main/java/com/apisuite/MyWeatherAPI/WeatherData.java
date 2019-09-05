package com.apisuite.MyWeatherAPI;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WeatherData {
	
	
	private int id;
	private String city;
	private Date date;
	private long temperature;
	private int wind;
	private int rain;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getWind() {
		return wind;
	}
	public void setWind(int wind) {
		this.wind = wind;
	}
	public int getRain() {
		return rain;
	}
	public void setRain(int rain) {
		this.rain = rain;
	}
	public long getTemperature() {
		return temperature;
	}
	public void setTemperature(long temperature) {
		this.temperature = temperature;
	}
	
	@Override
	public String toString() {
		return "WeatherData [id=" + id + ", city=" + city + ", date=" + date + ", wind=" + wind + ", rain=" + rain
				+ "]";
	}
	
}
