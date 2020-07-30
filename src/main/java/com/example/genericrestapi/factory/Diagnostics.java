package com.example.genericrestapi.factory;

import javax.xml.datatype.DatatypeConfigurationException;

import com.example.genericrestapi.response.CreateOrderRequest;
import com.example.genericrestapi.response.Response;

public abstract class Diagnostics {
	public abstract Response getOrder(String orderId);

	public abstract Response getReport(String orderId);

	public abstract Response createOrder(CreateOrderRequest createOrder) throws DatatypeConfigurationException;
}
