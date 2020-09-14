package com.example.genericrestapi.response;

import java.util.List;

import com.example.genericrestapi.request.Order;

public class OrderDetailsInfoResponse {
	
    public int status;
    public String message;
    public Data data;
    
	public static class Data{
	    public List<Order> orders;
	}


}
