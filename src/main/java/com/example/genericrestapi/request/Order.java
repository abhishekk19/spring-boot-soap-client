package com.example.genericrestapi.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
	
    public int _id;
    public int mode_of_service;
    public String tenantCode;
    public String orgCode;
    public String currencySymbol;
    public String currency;
    @JsonProperty("OStatus") 
    public int oStatus;
    @JsonProperty("WOStatus") 
    public int wOStatus;
    public String odid;
    public String wodid;
    public int wid;
    public String assaigned_to;

}
