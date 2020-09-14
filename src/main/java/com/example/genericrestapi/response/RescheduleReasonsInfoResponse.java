package com.example.genericrestapi.response;

import java.util.List;

public class RescheduleReasonsInfoResponse {
	
    public String status;
    public String value;
    public List<Data> data;

	public static class Data{
	    public String name;
	    public boolean status;
	    public int id;
	    public String corporate;
	}

}
