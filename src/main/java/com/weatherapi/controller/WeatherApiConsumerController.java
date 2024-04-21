package com.weatherapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.weatherapi.response.model.WeatherData;
import com.weatherapi.service.WeatherApiservice;

@RestController

public class WeatherApiConsumerController {

	@Autowired
	WeatherApiservice weatherService;
	
	@GetMapping("/hello")
	public String hello()
	{
		return "Hello!!!";
	}
	
	@GetMapping("/weathers/{city}")
	public ResponseEntity<String> getCurrentWeather(@PathVariable String city)
	{
		WeatherData data =weatherService.getCurrentWeatherData(city);
		String weatherDiscreption = data.getWeather().get(0).getDescription();
		double weatherTemp = kelvinToCelcius(data.getMain().getTemp());
		return new ResponseEntity<String>(weatherDiscreption+"  and temp is :"+weatherTemp, HttpStatus.OK);
	}

	private double kelvinToCelcius(double temp) {
		
		return temp-273.15;
	}
	
	
}
