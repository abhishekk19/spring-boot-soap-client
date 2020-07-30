package com.example.genericrestapi.service;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.genericrestapi.config.SOAPConnector;
import com.example.genericrestapi.createOrder.CreateOrderOPT;
import com.example.genericrestapi.createOrder.CreateOrderOPTResponse;
import com.example.genericrestapi.createOrder.GetOrderStatus;
import com.example.genericrestapi.createOrder.GetOrderStatusResponse;
import com.example.genericrestapi.createOrder.GetResultReportOPT;
import com.example.genericrestapi.createOrder.GetResultReportOPTResponse;
import com.example.genericrestapi.factory.Diagnostics;
import com.example.genericrestapi.request.ApiRequest;
import com.example.genericrestapi.response.CreateOrderRequest;
import com.example.genericrestapi.response.Response;
import com.google.gson.Gson;

@Service
public class SRLDiagnosticService extends Diagnostics {

	@Autowired
	SOAPConnector WebServicecClient;

	private String GET_ORDER_URL = "https://onlineorder.srl.in:86/service.asmx?op=GetOrderStatus";

	private String GET_REPORT_URL = "https://onlineorder.srl.in:86/service.asmx?op=GetResultReport_OPT";

	private String CREATE_ORDER_URL = "https://onlineorder.srl.in:86/service.asmx?op=CreateOrder_OPT";
	//https://onlineorder.srl.in:86/service.asmx?op=CreateOrder_OPT
	
	private String getOrder_soapActionUrl = "http://tempuri.org/GetOrderStatus";

	private String getReport_soapActionUrl = "http://tempuri.org/GetResultReport_OPT";

	private String createOrder_soapActionUrl = "http://tempuri.org/CreateOrder_OPT";

	
	private Gson gson = new Gson();

	ApiRequest apirequest = new ApiRequest();

	// SRL API
	public Response getOrder(String orderId) {

		GetOrderStatus orderStatusRequest = apirequest.prepareGetOrderStatus(orderId);
		GetOrderStatusResponse soapResponse = (GetOrderStatusResponse) WebServicecClient.callWebService(GET_ORDER_URL,
				orderStatusRequest, getOrder_soapActionUrl);

		// Constructing json as we are getting soap response asstring
		Response response = gson.fromJson(soapResponse.getGetOrderStatusResult(), Response.class);
		return response;
	}

	public Response getReport(String orderId) {
		GetResultReportOPT resultReport = apirequest.prepareResultReportOPT(orderId);
		GetResultReportOPTResponse soapResponse = (GetResultReportOPTResponse) WebServicecClient
				.callWebService(GET_REPORT_URL, resultReport, getReport_soapActionUrl);

		// Constructing json as we are getting soap response asstring
		Response response = gson.fromJson(soapResponse.getGetResultReportOPTResult(), Response.class);
		return response;
	}

	public Response createOrder(CreateOrderRequest createOrderRequest) throws DatatypeConfigurationException {
		
		CreateOrderOPT request = apirequest.prepareCreateOrderOPT(createOrderRequest);
		CreateOrderOPTResponse soapResponse = (CreateOrderOPTResponse) WebServicecClient
				.callWebService(CREATE_ORDER_URL, request, createOrder_soapActionUrl);

		// Constructing json as we are getting soap response asstring
		Response response = gson.fromJson(soapResponse.getCreateOrderOPTResult(), Response.class);
		return response;
		// TODO Auto-generated method stub
	}

}
