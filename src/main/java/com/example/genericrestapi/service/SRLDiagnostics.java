//package com.example.genericrestapi.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.genericrestapi.config.SOAPConnector;
//import com.example.genericrestapi.createOrder.GetOrderStatus;
//import com.example.genericrestapi.createOrder.GetOrderStatusResponse;
//import com.example.genericrestapi.createOrder.GetResultReport;
//import com.example.genericrestapi.createOrder.GetResultReportOPT;
//import com.example.genericrestapi.createOrder.GetResultReportOPTResponse;
//import com.example.genericrestapi.factory.Diagnostics;
//import com.example.genericrestapi.model.OrderStatusResponse;
//import com.example.genericrestapi.model.Response;
//import com.example.genericrestapi.model.ResultReportOPTResponse;
//import com.example.genericrestapi.util.MD5Util;
//import com.google.gson.Gson;
//
//
//public class SRLDiagnostics extends Diagnostics {
//
//	@Autowired
//	SOAPConnector WebServicecClient;
//	
//	@Autowired
//	DiagnosticService DiagnosticService ;
//
//	private final String DIAGNISTICS_SRL = "SRL";
//
//	private final String groupType = "1";
//
//	private final String source = "OPT";// dro
//
//	private String GET_ORDER_URL = "https://onlineorder.srl.in:86/service.asmx?op=GetOrderStatus";
//
//	private String GET_REPORT_URL = "https://onlineorder.srl.in:86/service.asmx?op=GetResultReport_OPT";
//
//	private String getOrder_soapActionUrl = "http://tempuri.org/GetOrderStatus";
//
//	private String getReport_soapActionUrl = "http://tempuri.org/GetResultReport_OPT";
//
//	private Gson gson = new Gson();
//
//	// SRL API
//	public Response getOrder(String orderId) {
//
////		String url = "https://onlineorder.srl.in:86/service.asmx?op=GetOrderStatus";
//
//		GetOrderStatus orderStatusRequest = new GetOrderStatus();
//		orderStatusRequest.setPORDERID(orderId);
//		orderStatusRequest.setGrouptyp(groupType);
//		orderStatusRequest.setSource(source);
//		String keyString = orderId + "|" + DIAGNISTICS_SRL;
//		orderStatusRequest.setStrVldTk(MD5Util.generateMd5Key(keyString));
//		GetOrderStatusResponse soapResponse = (GetOrderStatusResponse)DiagnosticService.getOrderStatus(orderStatusRequest);
//
//		// Constructing jspn as we are getting soap response asstring
//		// OrderStatusResponse orderStatusResponse = new OrderStatusResponse();
//		Response response = gson.fromJson(soapResponse.getGetOrderStatusResult(), Response.class);
//		// orderStatusResponse.setGetOrderStatusResult(response);
//		return response;
//	}
//
//	public Response getReport(String orderId) {
//		// String url =
//		// "https://onlineorder.srl.in:86/service.asmx?op=GetResultReport_OPT";
//
//		String keyString = orderId + "|" + DIAGNISTICS_SRL;
//
//		GetResultReportOPT resultReport = new GetResultReportOPT();
////		resultReport.setGrouptyp(groupType);
////		resultReport.setPORDERNO("ATE000162");
//		resultReport.setGrouptyp(groupType);
//		resultReport.setPORDERNO(orderId);
//		resultReport.setPCITY("");
//		resultReport.setPDEVICEID("");
//		resultReport.setPDEVICETOKEN("");
//		resultReport.setPOSVERSION("");
//		resultReport.setPMOBILENO("");
//		resultReport.setPEMAILID("");
//		resultReport.setPOSTYPE("");
//		resultReport.setPMYSRLVERSION("");
//		resultReport.setPPTNTCD("");
//		resultReport.setSource(source);
//
////		https://onlineorder.srl.in:86/service.asmx/GetResultReport_OPT
////			?P_CITY=&P_ORDERNO=ATE000162&P_PTNT_CD=&P_MOBILENO=&P_EMAIL_ID=&P_DEVICE_ID=1&P_DEVICE_TOKEN=1&P_OSTYPE=1&P_OSVERSION=1&P_MYSRL_VERSION=1.0.1&grouptyp=1&SOURCE=OPT&strVldTk=76c76cef4154550e2086664049546aee
//		resultReport.setStrVldTk(MD5Util.generateMd5Key(keyString));
//		System.out.println(MD5Util.generateMd5Key(keyString));
//		GetResultReportOPTResponse soapResponse = (GetResultReportOPTResponse) WebServicecClient
//				.callWebService(GET_REPORT_URL, resultReport, getReport_soapActionUrl);
//
//		// Constructing jspn as we are getting soap response asstring
//		// ResultReportOPTResponse resultReportOPTResponse = new
//		// ResultReportOPTResponse();
//		Response response = gson.fromJson(soapResponse.getGetResultReportOPTResult(), Response.class);
//		// resultReportOPTResponse.setGetResultReportOPTResult(response);
//
//		return response;
//
//	}
//
//	public Response createOrder() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//
//}
