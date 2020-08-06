package com.example.genericrestapi.factory;

import javax.xml.datatype.DatatypeConfigurationException;

import com.example.genericrestapi.request.CreateOrderRequest;
import com.example.genericrestapi.response.Response;

public interface Diagnostics {
	public Response getOrder(String orderId);

	public Response getReport(String orderId);

	public Response createOrder(CreateOrderRequest createOrder) throws DatatypeConfigurationException;
}
