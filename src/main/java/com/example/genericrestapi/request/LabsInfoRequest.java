package com.example.genericrestapi.request;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "method", "type", "application", "latitude", "longitude" , "service_item_code" , "tenantCode" , "organizationCode"})
public class LabsInfoRequest {
	
	    public String method;
	    public String type;
	    public String application;
	    public double latitude;
	    public double longitude;
	    public String service_item_code;
	    public String tenantCode;
	    public String organizationCode;

}
