package com.weatherapi.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityLatLong {

	public static Map<String, List<Double>> getLatLong()
	{
		HashMap<String, List<Double>> lastLongCity = new HashMap<>();
	
		lastLongCity.put("Pimpri", Arrays.asList(18.6298,73.7997));
		lastLongCity.put("Pune", Arrays.asList(18.5204,73.8567));
		lastLongCity.put("Kolhapur", Arrays.asList(16.7050,74.2433));
		lastLongCity.put("Solapur", Arrays.asList(17.6599,75.9064));
		lastLongCity.put("Nagpur", Arrays.asList(21.1458,79.0882));
		
		return Collections.unmodifiableMap(lastLongCity);
	}
}
