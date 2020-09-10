package com.example.genericrestapi.service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.genericrestapi.config.SOAPConnector;
import com.example.genericrestapi.constants.UrlConstants;
import com.example.genericrestapi.createOrder.CreateOrderOPT;
import com.example.genericrestapi.createOrder.CreateOrderOPTResponse;
import com.example.genericrestapi.createOrder.GetOrderStatus;
import com.example.genericrestapi.createOrder.GetOrderStatusResponse;
import com.example.genericrestapi.createOrder.GetResultReportOPT;
import com.example.genericrestapi.createOrder.GetResultReportOPTResponse;
import com.example.genericrestapi.factory.Diagnostics;
import com.example.genericrestapi.request.ApiRequest;
import com.example.genericrestapi.request.CreateOrderRequest;
import com.example.genericrestapi.response.LabInfo;
import com.example.genericrestapi.response.LabsInfoResponse;
import com.example.genericrestapi.response.Response;
import com.example.genericrestapi.response.TestInfo;
import com.example.genericrestapi.response.TestsInfoResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Service
public class CallHealthDiagnosticService implements Diagnostics {

	@Autowired
	SOAPConnector WebServicecClient;

	private Gson gson = new Gson();

	private ApiRequest apirequest = new ApiRequest();

	public TestsInfoResponse getAllTests() throws JsonMappingException, JsonProcessingException {

		ObjectMapper objectMapper = new ObjectMapper();

		String json = "{\r\n" + "    \"status\": \"SUCCESS\",\r\n" + "    \"statusCode\": 200,\r\n"
				+ "    \"dataObject\": [\r\n" + "        {\r\n" + "            \"code\": \"TS1500DGHDPAE0012\",\r\n"
				+ "            \"businessid\": 3,\r\n"
				+ "            \"name\": \"Complete Blood Count (CBC) /  CBP - Whole Blood\",\r\n"
				+ "            \"item_category\": \"Biochemistry\"\r\n" + "        },{\r\n"
				+ "            \"code\": \"TS1500DGHDBAC0105\",\r\n" + "            \"businessid\": 3,\r\n"
				+ "            \"name\": \"Lipid Profile\",\r\n" + "            \"item_category\": \"Biochemistry\"\r\n"
				+ "        }\r\n" + "    ],\r\n" + "    \"results_count\": 2,\r\n"
				+ "    \"reason\": \"Results Found\"\r\n" + "}\r\n" + "";
		TestsInfoResponse response = objectMapper.readValue(json, TestsInfoResponse.class);

		return response;

	}

	public TestsInfoResponse getTestsBySearchCategory() throws JsonMappingException, JsonProcessingException {

		ObjectMapper objectMapper = new ObjectMapper();

		String json = "{\r\n" + "    \"status\": \"SUCCESS\",\r\n" + "    \"statusCode\": 200,\r\n"
				+ "    \"dataObject\": [\r\n" + "        {\r\n" + "            \"code\": \"TS1500DGHDPAE0012\",\r\n"
				+ "            \"businessid\": 3,\r\n"
				+ "            \"name\": \"Complete Blood Count (CBC) /  CBP - Whole Blood\",\r\n"
				+ "            \"description\": \"CBC test is a basic blood test which helps to Screen for various conditions such as anemias,infections, inflammations, bleeding disorders, allergies and blood cancers and Diagnose above mentioned conditions when combined with other blood tests. Monitor the disease status or  effectiveness of treatment. Any increase or decrease in the test results may indicate that you have an underlying medical condition that requires further evaluation.\",\r\n"
				+ "            \"item_category\": \"Biochemistry\"\r\n" + "        }\r\n" + "    ],\r\n"
				+ "    \"results_count\": 1,\r\n" + "    \"reason\": \"Results Found\"\r\n" + "}";
		TestsInfoResponse response = objectMapper.readValue(json, TestsInfoResponse.class);

		return response;

	}

	public LabsInfoResponse getLabs() throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		String json = "{\r\n" + "    \"status\": \"SUCCESS\",\r\n" + "    \"statusCode\": 200,\r\n"
				+ "    \"dataObject\": [\r\n" + "        {\r\n" + "            \"code\": \"DC00000000000488\",\r\n"
				+ "            \"branch_id\": 1234,\r\n" + "            \"avg_rating\": 2,\r\n"
				+ "            \"name\": \"SWATANTHRA XRAY AND BIO CLINICAL LABORATORY\",\r\n"
				+ "            \"profile_pic\": \"https://s3-ap-southeast-1.amazonaws.com/associateinterface/\"\r\n"
				+ "        },\r\n" + "        {\r\n" + "            \"code\": \"DC00000000000495\",\r\n"
				+ "            \"branch_id\": 123,\r\n" + "            \"avg_rating\": 3.5,\r\n"
				+ "            \"name\": \"SRIVISHNU MULTI SPECIALITY HOSPITAL\",\r\n"
				+ "            \"profile_pic\": \"https://s3-ap-southeast-1.amazonaws.com/associateinterface/\"\r\n"
				+ "        }\r\n" + "    ],\r\n" + "    \"results_count\": 2,\r\n"
				+ "    \"reason\": \"Results Found\"\r\n" + "}";
		LabsInfoResponse response = objectMapper.readValue(json, LabsInfoResponse.class);

		return response;

	}

	@Override
	public Response getOrder(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getReport(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response createOrder(CreateOrderRequest createOrder) throws DatatypeConfigurationException {
		// TODO Auto-generated method stub
		return null;
	}
}
