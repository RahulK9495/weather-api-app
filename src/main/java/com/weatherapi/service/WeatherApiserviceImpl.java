package com.weatherapi.service;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherapi.response.dto.model.WeatherDataDto;
import com.weatherapi.response.model.WeatherData;
import com.weatherapi.util.CityLatLong;

@Service
public class WeatherApiserviceImpl implements WeatherApiservice {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	DozerBeanMapper dozerBeanMapper;
	
	double lat;
	double lon;
	
	@Value("${base_url}")
	String base_url;
	
	@Value("${apiKey}")
	String apiKey;
	
	ObjectMapper objMapper = new ObjectMapper();
	

	@Override
	public ResponseEntity<WeatherDataDto> getCurrentWeatherData(String city) throws JsonProcessingException {

		//To call OpenWeatherAPI
		calculateLatLong(city);
		
		String dynamicurl = base_url+"?lat="+lat+"&lon="+lon+"&appid="+apiKey;
		
		System.out.println("Calling api URL : "+dynamicurl);
		

		
		ResponseEntity<WeatherData> fetchedwetherData = restTemplate.getForEntity(dynamicurl, WeatherData.class);
		//map fetchedWeatherData to WeatherDataDTO
				String responseFromWeatherApi = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fetchedwetherData);
				System.out.println(">>>>>");
				
				System.out.println(responseFromWeatherApi);
				System.out.println("<<<<<");
		
		WeatherDataDto dto= dozerBeanMapper.map(fetchedwetherData.getBody(), WeatherDataDto.class);
		
		String jsonStr = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);
		System.out.println(">>>>>After DozerBean Mapper mapping :");
		System.out.println(jsonStr);
		System.out.println("<<<<<");
		
		return new ResponseEntity<WeatherDataDto>(dto, HttpStatus.OK);
	}

	private void calculateLatLong(String city) {

		List<Double> latlon = CityLatLong.getLatLong().get(city);
		lat = latlon.get(0);
		lat = latlon.get(1);

		
	}
	
	
	
	
	
}
