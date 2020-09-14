package com.example.genericrestapi.factory;

import javax.xml.datatype.DatatypeConfigurationException;

import com.example.genericrestapi.request.CreateOrderRequest;
import com.example.genericrestapi.request.CreateOrderResponse;
import com.example.genericrestapi.request.RegisterUserInfoRequest;
import com.example.genericrestapi.response.CreateOrdeInfoResponse;
import com.example.genericrestapi.response.LabsInfoResponse;
import com.example.genericrestapi.response.OrderDetailsInfoResponse;
import com.example.genericrestapi.response.RegisterUserAddressInfoResponse;
import com.example.genericrestapi.response.RegisterUserInfoResponse;
import com.example.genericrestapi.response.RescheduleReasonsInfoResponse;
import com.example.genericrestapi.response.Response;
import com.example.genericrestapi.response.TestsInfoResponse;
import com.example.genericrestapi.response.UserInfoResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface Diagnostics {
	
	public TestsInfoResponse getAllTests() throws JsonMappingException, JsonProcessingException;
	
	public TestsInfoResponse getTestsBySearchCategory() throws JsonMappingException, JsonProcessingException;

	public LabsInfoResponse getLabs() throws JsonMappingException, JsonProcessingException;
	
	public LabsInfoResponse getPhleboSlots() throws JsonMappingException, JsonProcessingException;
	
	public RegisterUserInfoResponse registerUser(RegisterUserInfoRequest userInfoRequest) throws JsonMappingException, JsonProcessingException;

	public RegisterUserAddressInfoResponse registerUserAddress() throws JsonMappingException, JsonProcessingException;

	public UserInfoResponse getUserDetails(String userId) throws JsonMappingException, JsonProcessingException;
	
	public OrderDetailsInfoResponse getOrderDetails(String orderId) throws JsonMappingException, JsonProcessingException;;

	public RescheduleReasonsInfoResponse saveRescheduleReasons() throws DatatypeConfigurationException, JsonMappingException, JsonProcessingException;

	
	public Response getReport(String orderId);

	public CreateOrderResponse createOrder(CreateOrderRequest createOrder) throws DatatypeConfigurationException;

	public CreateOrdeInfoResponse createOrder() throws DatatypeConfigurationException, JsonMappingException, JsonProcessingException;
}
