package com.weatherapi.util;

import org.dozer.CustomConverter;

public class TemperatureConverter implements CustomConverter {
	@Override
	public Object convert(Object existingDestinationFieldValue, Object sourceFieldValue, Class<?> destinationClass,
			Class<?> sourceClass) {

		if(sourceFieldValue == null)
			return null;
		if(sourceFieldValue instanceof Double) {
			double source =(Double)sourceFieldValue;
			
			//return kelvinToCelcius(source);
		}
		return 00;
	}

//private double kelvinToCelcius(double kelvintemp) {
//		
//		return kelvintemp-273.15;
//	}
	
}

