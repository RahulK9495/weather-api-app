package com.weatherapi.response.dto.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Main{
    public double temprature;
    public double feels_like;
    public double temp_min;
    public double temp_max;
    public int humidity;
}
