//package com.example.genericrestapi.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.genericrestapi.config.SOAPConnector;
//import com.example.genericrestapi.createOrder.GetOrderStatus;
//import com.example.genericrestapi.createOrder.GetResultReport;
//import com.example.genericrestapi.createOrder.GetResultReportOPT;
//
//@Service
//public class DiagnosticService {
//
//	@Autowired
//	SOAPConnector WebServicecClient;
//
//	// SRL API
//	public Object getOrderStatus(Object orderStatusRequest) {
//		String url = "https://onlineorder.srl.in:86/service.asmx?op=GetOrderStatus";
//		return WebServicecClient.callWebService(url, orderStatusRequest, "http://tempuri.org/GetOrderStatus");
//	}
//
//	public Object getResultReport(GetResultReportOPT resultReport) {
//		String url = "https://onlineorder.srl.in:86/service.asmx?op=GetResultReport_OPT";
//		return WebServicecClient.callWebService(url, resultReport, "http://tempuri.org/GetResultReport_OPT");
//	}
//
//}
