package com.example.genericrestapi.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrackOrderInfoResponse {
	
    public int status;
    public String message;
    public Data data;
	
	public static class Nomenclature{
	    public String _id;
	    @JsonProperty("Nomenclature") 
	    public String nomenclature;
	}

	public static class Data{
	    public int orderId;
	    public String odid;
	    public List<Nomenclature> nomenclature;
	}

}
