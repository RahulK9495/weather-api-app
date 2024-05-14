package com.weatherapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.weatherapi.response.dto.model.WeatherDataDto;
import com.weatherapi.response.model.WeatherData;

public interface WeatherApiservice  {

	public ResponseEntity<WeatherDataDto> getCurrentWeatherData(String city) throws JsonProcessingException;
	
}
