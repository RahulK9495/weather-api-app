package com.weatherapi.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.weatherapi.response.model.WeatherData;

public interface WeatherApiservice {

	public WeatherData getCurrentWeatherData(String city);
	
}
