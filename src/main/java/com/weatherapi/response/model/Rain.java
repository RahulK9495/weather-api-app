package com.weatherapi.response.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Rain {
    @JsonProperty("1h") 
    private double _1h;
    @JsonProperty("3h") 
    public double _3h;
}