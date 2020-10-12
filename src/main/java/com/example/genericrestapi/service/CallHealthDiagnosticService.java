package com.example.genericrestapi.service;

import java.util.LinkedHashMap;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.genericrestapi.config.RestService;
import com.example.genericrestapi.config.SOAPConnector;
import com.example.genericrestapi.factory.Diagnostics;
import com.example.genericrestapi.request.CallHealthApiRequest;
import com.example.genericrestapi.request.CreateOrderRequest;
import com.example.genericrestapi.request.LabsInfoRequest;
import com.example.genericrestapi.request.PhleboSlotsRequest;
import com.example.genericrestapi.request.RegisterUserRequest;
import com.example.genericrestapi.request.UserDetailsRequest;
import com.example.genericrestapi.response.CancelOrderInfoResponse;
import com.example.genericrestapi.response.CancelOrderReasonsInfoResponse;
import com.example.genericrestapi.response.CreateOrdeInfoResponse;
import com.example.genericrestapi.response.LabInfo;
import com.example.genericrestapi.response.LabsInfoResponse;
import com.example.genericrestapi.response.OrderDetailsInfoResponse;
import com.example.genericrestapi.response.PhleboSlotsinfoResponse;
import com.example.genericrestapi.response.RegisterUserAddressInfoResponse;
import com.example.genericrestapi.response.RegisterUserInfoResponse;
import com.example.genericrestapi.response.RescheduleOrderInfoResponse;
import com.example.genericrestapi.response.RescheduleReasonsInfoResponse;
import com.example.genericrestapi.response.Response;
import com.example.genericrestapi.response.TestsInfoResponse;
import com.example.genericrestapi.response.TrackOrderInfoResponse;
import com.example.genericrestapi.response.UserInfoResponse;
import com.example.genericrestapi.response.PhleboSlotsinfoResponse.SlotDate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Service
public class CallHealthDiagnosticService implements Diagnostics {

	@Autowired
	SOAPConnector WebServicecClient;

	@Autowired
	RestService restService;
	
	
	private CallHealthApiRequest callHealthApiRequest = new CallHealthApiRequest();

	private final String SOURCE_URL = "https://chgatewaydemo.callhealth.com/api/services";

	public TestsInfoResponse getAllTests() throws JsonMappingException, JsonProcessingException {

		String a = restService.getRestServiceCall("https://gorest.co.in/public-api/products");

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

	public LabsInfoResponse getLabs(Double latitude, Double longitude) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

//		String json = "{\r\n" + 
//				"\"method\":\"corporate/services/drReddy/associatesByServiceCodes\",\r\n" + 
//				"\"type\":\"POST\",\r\n" + 
//				"\"application\":\"ihs\",\r\n" + 
//				"\"request\":{\r\n" + 
//				"\"latitude\": 17.4146,\r\n" + 
//				"\"longitude\": 78.4383,\r\n" + 
//				"\"service_item_code\": \"DRL00001,DRL00001\",\r\n" + 
//				"\"tenantCode\": \"1000143\",\r\n" + 
//				"\"organizationCode\": \"100229\"\r\n" + 
//				"}\r\n" + 
//				"}";
//		LabsInfoRequest request = objectMapper.readValue(json, LabsInfoRequest.class);
		LabsInfoRequest request = callHealthApiRequest.prepareLabsInfoRequest(latitude, longitude);

		LinkedHashMap<String, LabInfo> o = (LinkedHashMap<String, LabInfo>) restService.postServiceCall(request, SOURCE_URL, Object.class);
		LabsInfoResponse response = new LabsInfoResponse();
		response.setLab(o);
		return response;

	}

	public PhleboSlotsinfoResponse getPhleboSlots() throws JsonMappingException, JsonProcessingException {
//		ObjectMapper objectMapper = new ObjectMapper();
//
//		String json = "{\"method\":\"api/officer_slots\", \"type\":\"POST\", \"application\":\"chiss\", \"request\":{ \"tenantCode\":\"1000143\", \"organizationCode\":\"100229\", \"from_date\":\"2020-09-24\", \"to_date\":\"2020-09-25\", \"business_id\":3, \"engagement_level\":1, \"patient_gender\":\"2\", \"service_did\":\"DRL0001\", \"pin_code\":\"500090\", \"patient_age\":34, \"order_latitude\":\"17.51863\", \"order_longitude\":\"78.396252\"\r\n" + 
//				"}\r\n" + 
//				"}";
//		PhleboSlotsRequest request = objectMapper.readValue(json, PhleboSlotsRequest.class);
		PhleboSlotsRequest request = callHealthApiRequest.preparePhleboSlotsRequest("17.51863", "78.396252", "2020-10-8", "2020-10-12", 34, "500090", "DRL0001", "2");

		LinkedHashMap<String, SlotDate> slots = (LinkedHashMap<String, SlotDate>)restService.postServiceCall(request, SOURCE_URL, Object.class);
		PhleboSlotsinfoResponse response = new PhleboSlotsinfoResponse();
		response.setSlots(slots);
		return response;

	}

	@Override
	public CreateOrdeInfoResponse createOrder()
			throws DatatypeConfigurationException, JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		// String a=restService.postServiceCall(request,
		// "https://postman-echo.com/post", responseType)
		String json = "{\r\n" + "    \"status\": \"SUCCESS\",\r\n" + "    \"statusCode\": 200,\r\n"
				+ "    \"dataObject\": \"orderId123\",\r\n" + "     \"reason\": \"Order created successfully\"\r\n"
				+ "}\r\n" + "";
		CreateOrdeInfoResponse response = objectMapper.readValue(json, CreateOrdeInfoResponse.class);

		return response;
	}

	public RegisterUserInfoResponse registerUser(RegisterUserRequest registerUserRequest)
			throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		String json = "{ \"method\":\"null\", \"type\":\"null\", \"application\":\"null\", \"request\":{ \"firstName\": \"Nar4\", \"lastName\": \"Nar4\", \"middleName\": \"\", \"salutation\":\"Mr.\", \"userName\": \"Nar@123\", \"gender\": \"2\", \"profilePicPath\":\"\", \"dob\": \"2000-01-01\", \"email\": \"nar1@nar1.com\", \"mobile\": \"9494710\", \"enabled\": 1, \"isActive\": 1, \"sourceType\": \"CORP\", \"password\": \"580895\", \"createdBy\": \"santharam\", \"organizationCode\": \"100229\", \"tenantCode\": \"1000143\", \"memberId\": \"1234567\", \"memberEmail\": \"drl@testmail.com\", \"designation\": \"test\", \"address\": [\r\n" + 
				"{ \"address\": \"tt\", \"addressType\":\"\", \"area\": \"area\", \"landmark\": \"tt\", \"zipcode\": \"state\", \"mandal\": \"\", \"district\": \"city\", \"city\": \"tt\", \"state\": \"500012\", \"country\": \"district\", \"isDefaultAddress\": 1, \"enabled\": 1, \"isActive\": 1, \"latitude\": \"0\", \"longitude\": \"0\", \"createdBy\": \"santharam\"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"}\r\n" + 
				"}";
		RegisterUserRequest request = objectMapper.readValue(json, RegisterUserRequest.class);
		
		registerUserRequest = callHealthApiRequest.prepareRegisterUserRequest(request);

		RegisterUserInfoResponse response  = (RegisterUserInfoResponse)restService.postServiceCall(registerUserRequest, SOURCE_URL, RegisterUserInfoResponse.class);
		return response;

	}

	public RegisterUserAddressInfoResponse registerUserAddress() throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		String json = "{\r\n" + "    \"status\": \"SUCCESS\",\r\n" + "    \"statusCode\": 200,\r\n"
				+ "    \"dataObject\": {\r\n" + "        \"authMrn\": null,\r\n" + "        \"accessToken\": null,\r\n"
				+ "        \"source\": null,\r\n" + "        \"createdDate\": \"2020-09-02T05:30:38.672+0000\",\r\n"
				+ "        \"modifiedDate\": \"2020-09-02T05:30:38.672+0000\",\r\n"
				+ "        \"customerAddrID\": 23393,\r\n" + "        \"customerMRNID\": \"8000001\",\r\n"
				+ "        \"addressType\": \"Home5\",\r\n" + "        \"isDefaultAddress\": 0,\r\n"
				+ "        \"country\": \"India\",\r\n" + "        \"state\": \"Andhra Pradesh\",\r\n"
				+ "        \"district\": \"Visakhapatnam\",\r\n" + "        \"mandal\": \"Visakhapatnam\",\r\n"
				+ "        \"city\": \"Visakhapatnam\",\r\n" + "        \"address\": \"Near Beach Road, Vizag\",\r\n"
				+ "        \"area\": \"Rk Beach\",\r\n" + "        \"landmark\": \"novotel\",\r\n"
				+ "        \"zipcode\": \"530027\",\r\n" + "        \"latitude\": \"2.32\",\r\n"
				+ "        \"longitude\": \"1.12\",\r\n" + "        \"enabled\": 1,\r\n"
				+ "        \"createdBy\": \"admin\",\r\n" + "        \"modifiedBy\": null\r\n" + "    },\r\n"
				+ "      \"reason\": \"Details inserted successfully\"\r\n" + "}\r\n" + "";
		RegisterUserAddressInfoResponse response = objectMapper.readValue(json, RegisterUserAddressInfoResponse.class);

		return response;

	}

	@Override
	public UserInfoResponse getUserDetails(String userId) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		//String json = "{\"method\":\"globalmaster/gcm/corporate/customer/fullDetails\", \"type\":\"POST\", \"application\":\"gcm\", \"request\":{ \"mrn\":\"8956088\" }}";
		//UserDetailsRequest request = objectMapper.readValue(json, UserDetailsRequest.class);
		UserDetailsRequest request = callHealthApiRequest.prepareUserDetailsRequest("8956088");
		UserInfoResponse response =(UserInfoResponse) restService.postServiceCall(request, SOURCE_URL, UserInfoResponse.class);

		return response;
	}

	@Override
	public OrderDetailsInfoResponse getOrderDetails(String orderId)
			throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		String json = "{\r\n" + "    \"status\": 1,\r\n" + "    \"message\": \"success\",\r\n" + "    \"data\": {\r\n"
				+ "        \"orders\": [\r\n" + "            {\r\n" + "                \"_id\": 2781815,\r\n"
				+ "                \"mode_of_service\": 3,\r\n" + "                \"tenantCode\": \"1000001\",\r\n"
				+ "                \"orgCode\": \"100001\",\r\n" + "                \"currencySymbol\": \"U+20B9\",\r\n"
				+ "                \"currency\": \"Rs\",\r\n" + "                \"OStatus\": 1,\r\n"
				+ "                \"WOStatus\": 1,\r\n" + "                \"odid\": \"EC-AP-020920-2326837\",\r\n"
				+ "                \"wodid\": \"WO-000-20-5154168\",\r\n" + "                \"wid\": 3040773,\r\n"
				+ "                \"assaigned_to\": \"101606\"\r\n" + "            },\r\n" + "            {\r\n"
				+ "                \"_id\": 2780802,\r\n" + "                \"mode_of_service\": 1,\r\n"
				+ "                \"tenantCode\": \"1000001\",\r\n" + "                \"orgCode\": \"100001\",\r\n"
				+ "                \"currencySymbol\": \"U+20B9\",\r\n" + "                \"currency\": \"Rs\",\r\n"
				+ "                \"OStatus\": 0,\r\n" + "                \"WOStatus\": 0,\r\n"
				+ "                \"odid\": \"DG-AH-310820-2325824\",\r\n"
				+ "                \"wodid\": \"WO-000-20-5153130\",\r\n" + "                \"wid\": 3039735,\r\n"
				+ "                \"assaigned_to\": \"\"\r\n" + "            },\r\n" + "            {\r\n"
				+ "                \"_id\": 2780728,\r\n" + "                \"mode_of_service\": 3,\r\n"
				+ "                \"tenantCode\": \"1000001\",\r\n" + "                \"orgCode\": \"100001\",\r\n"
				+ "                \"currencySymbol\": \"U+20B9\",\r\n" + "                \"currency\": \"Rs\",\r\n"
				+ "                \"OStatus\": 1,\r\n" + "                \"WOStatus\": 1,\r\n"
				+ "                \"odid\": \"EC-AP-290820-2325750\",\r\n"
				+ "                \"wodid\": \"WO-000-20-5153001\",\r\n" + "                \"wid\": 3039606,\r\n"
				+ "                \"assaigned_to\": \"101700\"\r\n" + "            }\r\n" + "                ]\r\n"
				+ "        }\r\n" + "}";
		OrderDetailsInfoResponse response = objectMapper.readValue(json, OrderDetailsInfoResponse.class);

		return response;
	}

	@Override
	public TrackOrderInfoResponse trackOrder()
			throws DatatypeConfigurationException, JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		String json = "{\r\n" + "    \"status\": 1,\r\n" + "    \"message\": \"success\",\r\n" + "    \"data\": {\r\n"
				+ "                \"orderId\" : 2781815,\r\n"
				+ "                \"odid\" : \"EC-AP-020920-2326837\",\r\n"
				+ "                \"nomenclature\" : [\r\n" + "                        {\r\n"
				+ "                                \"_id\" : \"5cecde54b67824dc1c7fd811\",\r\n"
				+ "                                \"Nomenclature\" : \"Consultation Confirmed\"\r\n"
				+ "                        }\r\n" + "                ]\r\n" + "        }    \r\n" + "}";
		TrackOrderInfoResponse response = objectMapper.readValue(json, TrackOrderInfoResponse.class);

		return response;
	}

	@Override
	public CancelOrderInfoResponse cancelOrder()
			throws DatatypeConfigurationException, JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		String json = "{\r\n" + "    \"status\": \"1\",\r\n" + "    \"msg\": [\r\n" + "        {\r\n"
				+ "            \"response\": \"1\",\r\n"
				+ "            \"msg\": \"Order_id: 2096030 is Cancelled\",\r\n"
				+ "            \"chiss_response\": [\r\n" + "                {\r\n"
				+ "                    \"status\": 1,\r\n"
				+ "                    \"message\": \"Order Cancelled Successfully\"\r\n" + "                }\r\n"
				+ "            ]\r\n" + "        }\r\n" + "    ]\r\n" + "}";
		CancelOrderInfoResponse response = objectMapper.readValue(json, CancelOrderInfoResponse.class);

		return response;
	}

	@Override
	public CancelOrderReasonsInfoResponse[] getCancelOrderReasons()
			throws DatatypeConfigurationException, JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		String json = "[\r\n" + "   {\r\n" + "      \"id\":1,\r\n" + "      \"name\":\"Application issue\",\r\n"
				+ "      \"careplan\":0,\r\n" + "      \"status\":true,\r\n" + "      \"created_by\":\"\"\r\n"
				+ "   },\r\n" + "   {\r\n" + "      \"id\":2,\r\n" + "      \"name\":\"Customer\",\r\n"
				+ "      \"careplan\":0,\r\n" + "      \"status\":true,\r\n" + "      \"created_by\":\"\"\r\n"
				+ "   },\r\n" + "   {\r\n" + "      \"id\":3,\r\n" + "      \"name\":\"Denial\",\r\n"
				+ "      \"careplan\":0,\r\n" + "      \"status\":true,\r\n" + "      \"created_by\":\"\"\r\n"
				+ "   },\r\n" + "   {\r\n" + "      \"id\":4,\r\n" + "      \"name\":\"Price / Product\",\r\n"
				+ "      \"careplan\":0,\r\n" + "      \"status\":true,\r\n" + "      \"created_by\":\"\"\r\n"
				+ "   },\r\n" + "   {\r\n" + "      \"id\":5,\r\n" + "      \"name\":\"Service related\",\r\n"
				+ "      \"careplan\":1,\r\n" + "      \"status\":true,\r\n" + "      \"created_by\":\"\"\r\n"
				+ "   },\r\n" + "   {\r\n" + "      \"id\":6,\r\n" + "      \"name\":\"Skill issue\",\r\n"
				+ "      \"careplan\":0,\r\n" + "      \"status\":true,\r\n" + "      \"created_by\":\"\"\r\n"
				+ "   },\r\n" + "   {\r\n" + "      \"id\":7,\r\n" + "      \"name\":\"Officer related\",\r\n"
				+ "      \"careplan\":0,\r\n" + "      \"status\":true,\r\n" + "      \"created_by\":\"\"\r\n"
				+ "   },\r\n" + "   {\r\n" + "      \"id\":8,\r\n" + "      \"name\":\"Order related\",\r\n"
				+ "      \"careplan\":0,\r\n" + "      \"status\":true,\r\n" + "      \"created_by\":\"\"\r\n"
				+ "   },\r\n" + "   {\r\n" + "      \"id\":9,\r\n" + "      \"name\":\"Care Plan Related\",\r\n"
				+ "      \"careplan\":1,\r\n" + "      \"status\":true,\r\n" + "      \"created_by\":\"mallesh\"\r\n"
				+ "   },\r\n" + "   {\r\n" + "      \"id\":10,\r\n"
				+ "      \"name\":\"Different Vendor collected Samples\",\r\n" + "      \"corporate\":\"B2B\",\r\n"
				+ "      \"careplan\":0,\r\n" + "      \"status\":true,\r\n" + "      \"created_by\":\"mallesh.g\"\r\n"
				+ "   },\r\n" + "   {\r\n" + "      \"id\":11,\r\n" + "      \"name\":\"policy cancellation\",\r\n"
				+ "      \"corporate\":\"B2B\",\r\n" + "      \"careplan\":0,\r\n" + "      \"status\":true,\r\n"
				+ "      \"created_by\":\"mallesh.g\"\r\n" + "   },\r\n" + "   {\r\n" + "      \"id\":12,\r\n"
				+ "      \"name\":\"Customer is not cooperating\",\r\n" + "      \"corporate\":\"B2B\",\r\n"
				+ "      \"careplan\":0,\r\n" + "      \"status\":true,\r\n" + "      \"created_by\":\"mallesh.g\"\r\n"
				+ "   },\r\n" + "   {\r\n" + "      \"id\":13,\r\n" + "      \"name\":\"waive of medicals\",\r\n"
				+ "      \"corporate\":\"B2B\",\r\n" + "      \"careplan\":0,\r\n" + "      \"status\":true,\r\n"
				+ "      \"created_by\":\"mallesh.g\"\r\n" + "   },\r\n" + "   {\r\n" + "      \"id\":14,\r\n"
				+ "      \"name\":\"Non Serviciable location\",\r\n" + "      \"corporate\":\"B2B\",\r\n"
				+ "      \"careplan\":0,\r\n" + "      \"status\":true,\r\n" + "      \"created_by\":\"mallesh.g\"\r\n"
				+ "   }\r\n" + "]";
		CancelOrderReasonsInfoResponse[] response = objectMapper.readValue(json,
				CancelOrderReasonsInfoResponse[].class);

		return response;
	}

	@Override
	public RescheduleOrderInfoResponse rescheduleOrder()
			throws DatatypeConfigurationException, JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		String json = "{\r\n" + "    \"status\": 1,\r\n" + "    \"code\": \"10100\",\r\n"
				+ "    \"message\": \"Order rescheduled successfully\"\r\n" + "}";
		RescheduleOrderInfoResponse response = objectMapper.readValue(json, RescheduleOrderInfoResponse.class);

		return response;
	}

	@Override
	public RescheduleReasonsInfoResponse saveRescheduleReasons()
			throws DatatypeConfigurationException, JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		String json = "{\"status\":\"success\",\"value\":\"Data fetched successfully.\",\"data\":[{\"name\":\"Customer not Availabile\",\"status\":true,\"id\":6,\"corporate\":\"B2B\"},{\"name\":\"Not Met Pre Requisites\",\"status\":true,\"id\":7,\"corporate\":\"B2B\"},{\"name\":\"Health Issues\",\"status\":true,\"id\":8,\"corporate\":\"B2B\"},{\"name\":\"Not Reached on time\",\"status\":true,\"id\":9,\"corporate\":\"B2B\"},{\"name\":\"Equipment\",\"status\":true,\"id\":10,\"corporate\":\"B2B\"},{\"name\":\"Wrong Mapping\",\"status\":true,\"id\":11,\"corporate\":\"B2B\"}]}";
		RescheduleReasonsInfoResponse response = objectMapper.readValue(json, RescheduleReasonsInfoResponse.class);

		return response;
	}

	@Override
	public Response getReport(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreateOrderRequest createOrder(CreateOrderRequest createOrder) throws DatatypeConfigurationException {
		// TODO Auto-generated method stub
		return null;
	}

}
