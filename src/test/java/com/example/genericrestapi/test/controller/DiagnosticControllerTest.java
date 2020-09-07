//package com.example.genericrestapi.test.controller;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import com.example.genericrestapi.config.SOAPConnector;
//import com.example.genericrestapi.constants.UrlConstants;
//import com.example.genericrestapi.controllers.DiagnosticController;
//import com.example.genericrestapi.createOrder.GetOrderStatus;
//import com.example.genericrestapi.createOrder.GetOrderStatusResponse;
//import com.example.genericrestapi.factory.Diagnostics;
//import com.example.genericrestapi.factory.DiagnosticsFactory;
//import com.example.genericrestapi.request.ApiRequest;
//import com.example.genericrestapi.response.Response;
//import com.example.genericrestapi.service.SRLDiagnosticService;
//
//public class DiagnosticControllerTest extends AbstractTest {
//
//	@InjectMocks
//	DiagnosticController diagnosticController;
//
//	@Mock
//	Diagnostics diagnostics;
//
//	@Mock
//	DiagnosticsFactory diagnosticsFactory;
//
//	@Mock
//	SRLDiagnosticService srlDiagnosticService;
//
//	@Test
//	public void getOrder() throws Exception {
//		String uri = "/orders/1?orderId=ATG000004";
//		Response res = new Response();
//		res.setCode("100");
//		res.setData("Accepted");
//		res.setMsg("");
//		ApiRequest apirequest = new ApiRequest();
//
//		GetOrderStatusResponse getOrderStatusResponse = new GetOrderStatusResponse();
//		GetOrderStatus orderStatusRequest = apirequest.prepareGetOrderStatus("test123");
//
//		when(diagnosticsFactory.createDiagnostics(1L)).thenReturn(new SRLDiagnosticService());
////		when((GetOrderStatusResponse) WebServicecClient.callWebService(UrlConstants.GET_ORDER_URL, orderStatusRequest,
////				UrlConstants.getOrder_soapActionUrl)).thenReturn(getOrderStatusResponse);
//		when(diagnostics.getOrder("")).thenReturn(res);
//		when(srlDiagnosticService.getOrder("")).thenReturn(res);
//		ResponseEntity<?> response = diagnosticController.getOrderStatus(1L, "");
//		assertEquals("Accepted", response.getStatusCode());
////      Product[] productlist = super.mapFromJson(content, Product[].class);
////      assertTrue(productlist.length > 0);
//	}
//   @Test
//   public void createProduct() throws Exception {
//      String uri = "/products";
//      Product product = new Product();
//      product.setId("3");
//      product.setName("Ginger");
//      String inputJson = super.mapToJson(product);
//      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
//         .contentType(MediaType.APPLICATION_JSON_VALUE)
//         .content(inputJson)).andReturn();
//      
//      int status = mvcResult.getResponse().getStatus();
//      assertEquals(201, status);
//      String content = mvcResult.getResponse().getContentAsString();
//      assertEquals(content, "Product is created successfully");
//   }
//   @Test
//   public void updateProduct() throws Exception {
//      String uri = "/products/2";
//      Product product = new Product();
//      product.setName("Lemon");
//      String inputJson = super.mapToJson(product);
//      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
//         .contentType(MediaType.APPLICATION_JSON_VALUE)
//         .content(inputJson)).andReturn();
//      
//      int status = mvcResult.getResponse().getStatus();
//      assertEquals(200, status);
//      String content = mvcResult.getResponse().getContentAsString();
//      assertEquals(content, "Product is updated successsfully");
//   }
//   @Test
//   public void deleteProduct() throws Exception {
//      String uri = "/products/2";
//      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
//      int status = mvcResult.getResponse().getStatus();
//      assertEquals(200, status);
//      String content = mvcResult.getResponse().getContentAsString();
//      assertEquals(content, "Product is deleted successsfully");
//   }
//}