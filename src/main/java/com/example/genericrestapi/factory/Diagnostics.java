package com.example.genericrestapi.factory;

import javax.xml.datatype.DatatypeConfigurationException;

import com.example.genericrestapi.request.CreateOrderRequest;
import com.example.genericrestapi.response.LabsInfoResponse;
import com.example.genericrestapi.response.Response;
import com.example.genericrestapi.response.TestsInfoResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface Diagnostics {
	
	public TestsInfoResponse getAllTests() throws JsonMappingException, JsonProcessingException;
	
	public TestsInfoResponse getTestsBySearchCategory() throws JsonMappingException, JsonProcessingException;

	public LabsInfoResponse getLabs() throws JsonMappingException, JsonProcessingException;
	
	public Response getOrder(String orderId);

	public Response getReport(String orderId);

	public Response createOrder(CreateOrderRequest createOrder) throws DatatypeConfigurationException;
}
