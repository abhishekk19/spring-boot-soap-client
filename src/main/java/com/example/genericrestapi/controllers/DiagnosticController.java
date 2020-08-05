package com.example.genericrestapi.controllers;

import java.io.IOException;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.genericrestapi.factory.Diagnostics;
import com.example.genericrestapi.factory.DiagnosticsFactory;
import com.example.genericrestapi.request.CreateOrderRequest;
import com.example.genericrestapi.service.SRLDiagnosticService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/diagnostics")
public class DiagnosticController {

	@Autowired
	SRLDiagnosticService srlDiagnosticService;

	@Autowired
	DiagnosticsFactory diagnosticsFactory;

	@ApiOperation(value = "Get the specific order status")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list", response = Object.class),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "/orders/{diagnosticId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getOrderStatus(@PathVariable Long diagnosticId, @RequestParam String orderId)
			throws JsonParseException, JsonMappingException, IOException {
//orderid:ATG000004
		Diagnostics diagnostics = diagnosticsFactory.createDiagnostics(diagnosticId);
		Object response = diagnostics.getOrder(orderId);
		return new ResponseEntity<>((response), HttpStatus.OK);

	}

	@ApiOperation(value = "get the specific order report")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list", response = Object.class),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "/reports/{diagnosticId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getResultReport(@PathVariable Long diagnosticId, @RequestParam String orderId) {

//		resultReport.setPORDERNO("ATE000162");
		Diagnostics diagnostics = diagnosticsFactory.createDiagnostics(diagnosticId);
		Object response = diagnostics.getReport(orderId);

		return new ResponseEntity<>((response), HttpStatus.OK);

	}

	@ApiOperation(value = "Create Order")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "/Order/{diagnosticId}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> createOrder(@PathVariable Long diagnosticId, @RequestBody CreateOrderRequest createOrderRequest)
			throws DatatypeConfigurationException {

//		resultReport.setPORDERNO("ATE000162");
		Diagnostics diagnostics = diagnosticsFactory.createDiagnostics(diagnosticId);
		Object response = diagnostics.createOrder(createOrderRequest);

		return new ResponseEntity<>((response), HttpStatus.OK);

	}

}