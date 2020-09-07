package com.example.genericrestapi.test.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import javax.xml.datatype.DatatypeConfigurationException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


import com.example.genericrestapi.config.SOAPConnector;
import com.example.genericrestapi.createOrder.CreateOrderOPTResponse;
import com.example.genericrestapi.createOrder.GetOrderStatusResponse;
import com.example.genericrestapi.createOrder.GetResultReportOPTResponse;
import com.example.genericrestapi.request.CreateOrderRequest;
import com.example.genericrestapi.response.Response;
import com.example.genericrestapi.service.SRLDiagnosticService;

@RunWith(MockitoJUnitRunner.class)
public class SRLDiagnosticServiceTest {

	@InjectMocks
	SRLDiagnosticService diagnosticService;

	@Mock
	SOAPConnector WebServicecClient;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void getOrderSuccess() {
		String orderId = "sdfsdf34";
		GetOrderStatusResponse getOrderStatusResponse = new GetOrderStatusResponse();
		getOrderStatusResponse.setGetOrderStatusResult("{  \"code\": \"100\",\r\n"
				+ "  \"msg\": \"Query Successful\",\r\n" + "  \"data\": \"ACCEPTED\"\r\n" + "}");
		when(WebServicecClient.callWebService(Mockito.anyString(), Mockito.anyObject(),
				Mockito.anyString())).thenReturn(getOrderStatusResponse);
		Response res = diagnosticService.getOrder(orderId);
		assertEquals("100", res.getCode());
		assertEquals("Query Successful", res.getMsg());
		assertEquals("ACCEPTED", res.getData());

	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void getReportSuccess() {
		String orderId = "sdfsdf34";
		GetResultReportOPTResponse resultReportOPTResponse = new GetResultReportOPTResponse();
		resultReportOPTResponse.setGetResultReportOPTResult("{  \"code\": \"100\",\r\n"
				+ "  \"msg\": \"Query Successful\",\r\n" + "  \"data\": \"https://testurl.com\"\r\n" + "}");
		when(WebServicecClient.callWebService(Mockito.anyString(), Mockito.anyObject(),
				Mockito.anyString())).thenReturn(resultReportOPTResponse);
		Response res = diagnosticService.getReport(orderId);
		assertEquals("100", res.getCode());
		assertEquals("Query Successful", res.getMsg());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void getReportInvalid() {
		String orderId = "sdfsdf34";
		GetResultReportOPTResponse resultReportOPTResponse = new GetResultReportOPTResponse();
		resultReportOPTResponse.setGetResultReportOPTResult("{  \"code\": \"100\",\r\n"
				+ "  \"msg\": \"No Report Found\",\r\n" + "  \"data\": \"https://testurl.com\"\r\n" + "}");
		when(WebServicecClient.callWebService(Mockito.anyString(), Mockito.anyObject(),
				Mockito.anyString())).thenReturn(resultReportOPTResponse);
		Response res = diagnosticService.getReport(orderId);
		assertEquals("100", res.getCode());
		assertEquals("No Report Found", res.getMsg());
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void createOrderSuccess() throws DatatypeConfigurationException {
		CreateOrderRequest createOrderRequest = new CreateOrderRequest();
		CreateOrderOPTResponse createOrderOPTResponse = new CreateOrderOPTResponse();
		createOrderOPTResponse.setCreateOrderOPTResult("{  \"code\": \"100\",\r\n"
				+ "  \"msg\": \"Query Successful\",\r\n" + "  \"data\": \"testId123\"\r\n" + "}");
		when(WebServicecClient.callWebService(Mockito.anyString(), Mockito.anyObject(),
				Mockito.anyString())).thenReturn(createOrderOPTResponse);
		Response res = diagnosticService.createOrder(createOrderRequest);
		assertEquals("100", res.getCode());
		assertEquals("testId123", res.getData());
		assertEquals("Query Successful", res.getMsg());

	}
}
