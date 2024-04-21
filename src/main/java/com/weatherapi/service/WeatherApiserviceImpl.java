package com.weatherapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weatherapi.response.model.WeatherData;
import com.weatherapi.util.CityLatLong;

@Service
public class WeatherApiserviceImpl implements WeatherApiservice {

	@Autowired
	RestTemplate restTemplate;
	
	double lat;
	double lon;
	
	@Value("${base_url}")
	String base_url;
	
	@Value("${apiKey}")
	String apiKey;

	@Override
	public WeatherData getCurrentWeatherData(String city) {

		//To call OpenWeatherAPI
		calculateLatLong(city);
		
		String dynamicurl = base_url+"?lat="+lat+"&lon="+lon+"&appid="+apiKey;
		
		System.out.println("Calling api URL : "+dynamicurl);
		

		
		ResponseEntity<WeatherData> fetchedwetherData = restTemplate.getForEntity(dynamicurl, WeatherData.class);
		
		WeatherData data = fetchedwetherData.getBody();
		return data;
	}

	private void calculateLatLong(String city) {

	
		lat = CityLatLong.getLatLong().get(city).get(0);
		lon = CityLatLong.getLatLong().get(city).get(1);
		
	}
	
	
	
}
