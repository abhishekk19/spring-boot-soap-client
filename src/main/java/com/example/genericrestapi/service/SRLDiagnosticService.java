package com.example.genericrestapi.service;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.genericrestapi.response.CreateOrderRequest;
import com.example.genericrestapi.response.Response;
import com.google.gson.Gson;

@Service
public class SRLDiagnosticService implements Diagnostics {

	@Autowired
	SOAPConnector WebServicecClient;

	private Gson gson = new Gson();

	private ApiRequest apirequest = new ApiRequest();

	// SRL API
	@Override
	public Response getOrder(String orderId) {

		GetOrderStatus orderStatusRequest = apirequest.prepareGetOrderStatus(orderId);
		GetOrderStatusResponse soapResponse = (GetOrderStatusResponse) WebServicecClient.callWebService(UrlConstants.GET_ORDER_URL,
				orderStatusRequest,UrlConstants.getOrder_soapActionUrl);

		// Constructing json as we are getting soap response asstring
		Response response = gson.fromJson(soapResponse.getGetOrderStatusResult(), Response.class);
		return response;
	}

	@Override
	public Response getReport(String orderId) {
		GetResultReportOPT resultReport = apirequest.prepareResultReportOPT(orderId);
		GetResultReportOPTResponse soapResponse = (GetResultReportOPTResponse) WebServicecClient
				.callWebService(UrlConstants.GET_REPORT_URL, resultReport, UrlConstants.getReport_soapActionUrl);

		// Constructing json as we are getting soap response asstring
		Response response = gson.fromJson(soapResponse.getGetResultReportOPTResult(), Response.class);
		return response;
	}

	@Override
	public Response createOrder(CreateOrderRequest createOrderRequest) throws DatatypeConfigurationException {

		CreateOrderOPT request = apirequest.prepareCreateOrderOPT(createOrderRequest);
		CreateOrderOPTResponse soapResponse = (CreateOrderOPTResponse) WebServicecClient
				.callWebService(UrlConstants.CREATE_ORDER_URL, request, UrlConstants.createOrder_soapActionUrl);

		// Constructing json as we are getting soap response asstring
		Response response = gson.fromJson(soapResponse.getCreateOrderOPTResult(), Response.class);
		return response;
	}

}
