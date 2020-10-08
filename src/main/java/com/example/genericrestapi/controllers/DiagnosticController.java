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
import com.example.genericrestapi.factory.GenericFactory;
import com.example.genericrestapi.request.CancelOrderRequest;
import com.example.genericrestapi.request.CreateOrderRequest;
import com.example.genericrestapi.request.PhleboSlotsRequest;
import com.example.genericrestapi.request.RegisterUserAddressInfoRequest;
import com.example.genericrestapi.request.RegisterUserInfoRequest;
import com.example.genericrestapi.request.RescheduleOrderRequest;
import com.example.genericrestapi.request.SlotRequest;
import com.example.genericrestapi.response.CancelOrderInfoResponse;
import com.example.genericrestapi.response.CancelOrderReasonsInfoResponse;
import com.example.genericrestapi.response.CreateOrdeInfoResponse;
import com.example.genericrestapi.response.LabsInfoResponse;
import com.example.genericrestapi.response.PhleboSlotsinfoResponse;
import com.example.genericrestapi.response.RegisterUserAddressInfoResponse;
import com.example.genericrestapi.response.RegisterUserInfoResponse;
import com.example.genericrestapi.response.RescheduleOrderInfoResponse;
import com.example.genericrestapi.response.RescheduleReasonsInfoResponse;
import com.example.genericrestapi.response.TestsInfoResponse;
import com.example.genericrestapi.response.TrackOrderInfoResponse;
import com.example.genericrestapi.response.UserInfoResponse;
import com.example.genericrestapi.service.SRLDiagnosticService;
import com.example.genericrestapi.util.ResponseUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
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
	GenericFactory genericFactory;

	ResponseUtil responseUtil = new ResponseUtil();

	@ApiOperation(value = "Get the list of Test codes and Test names")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list", response = Object.class),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "{diagnosticId}/tests", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getAllTests(@PathVariable Long diagnosticId)
			throws JsonParseException, JsonMappingException, IOException {

		Diagnostics diagnostics = genericFactory.createDiagnostics(diagnosticId);
		TestsInfoResponse response = diagnostics.getAllTests();
		if (response == null) {
			return new ResponseEntity<>((responseUtil.generateNoAPIResponse()), HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<>((response), HttpStatus.OK);

	}

	@ApiOperation(value = "Get the list of Test codes based on lab visit or home sample pick up")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list", response = Object.class),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "{diagnosticId}/tests/{search}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getTestsBySearchCategory(@PathVariable Long diagnosticId, @PathVariable String search)
			throws JsonParseException, JsonMappingException, IOException {

		Diagnostics diagnostics = genericFactory.createDiagnostics(diagnosticId);
		TestsInfoResponse response = diagnostics.getTestsBySearchCategory();
		if (response == null) {
			return new ResponseEntity<>((responseUtil.generateNoAPIResponse()), HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<>((response), HttpStatus.OK);

	}

	@ApiOperation(value = "Get the list of Labs based on codes")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list", response = Object.class),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "{diagnosticId}/labs", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getLabs(@PathVariable Long diagnosticId ,@RequestParam Double latitude,@RequestParam Double longitude)
			throws JsonParseException, JsonMappingException, IOException {

		Diagnostics diagnostics = genericFactory.createDiagnostics(diagnosticId);
		LabsInfoResponse response = diagnostics.getLabs(latitude, longitude);
		if (response == null) {
			return new ResponseEntity<>((responseUtil.generateNoAPIResponse()), HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<>((response), HttpStatus.OK);

	}

	@ApiOperation(value = "Create Order")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "{diagnosticId}/order", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> createOrder(@PathVariable Long diagnosticId,
			@RequestBody CreateOrderRequest createOrderRequest)
			throws DatatypeConfigurationException, JsonMappingException, JsonProcessingException {

		Diagnostics diagnostics = genericFactory.createDiagnostics(diagnosticId);
		CreateOrdeInfoResponse response = diagnostics.createOrder();
		if (response == null) {
			return new ResponseEntity<>((responseUtil.generateNoAPIResponse()), HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<>((response), HttpStatus.OK);

	}

	@ApiOperation(value = "Get Phlebo Slot Selection based on Customer Location")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list", response = Object.class),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "{diagnosticId}/slots", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> getPhleboSlots(@PathVariable Long diagnosticId,
			@RequestBody SlotRequest SlotRequest)
			throws JsonParseException, JsonMappingException, IOException {

		Diagnostics diagnostics = genericFactory.createDiagnostics(diagnosticId);
		PhleboSlotsinfoResponse response = diagnostics.getPhleboSlots();
		if (response == null) {
			return new ResponseEntity<>((responseUtil.generateNoAPIResponse()), HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<>((response), HttpStatus.OK);

	}

	@ApiOperation(value = "Registration of the user")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list", response = Object.class),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "{diagnosticId}/User", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> registerUser(@PathVariable Long diagnosticId, @RequestBody RegisterUserInfoRequest request)
			throws JsonParseException, JsonMappingException, IOException {

		Diagnostics diagnostics = genericFactory.createDiagnostics(diagnosticId);
		RegisterUserInfoResponse response = diagnostics.registerUser(request);
		if (response == null) {
			return new ResponseEntity<>((responseUtil.generateNoAPIResponse()), HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<>((response), HttpStatus.OK);

	}

	@ApiOperation(value = "Registration of the user Address")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list", response = Object.class),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "{diagnosticId}/UserAddress", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> registerUserAddress(@PathVariable Long diagnosticId , @RequestBody RegisterUserAddressInfoRequest request)
			throws JsonParseException, JsonMappingException, IOException {

		Diagnostics diagnostics = genericFactory.createDiagnostics(diagnosticId);
		RegisterUserAddressInfoResponse response = diagnostics.registerUserAddress();
		if (response == null) {
			return new ResponseEntity<>((responseUtil.generateNoAPIResponse()), HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<>((response), HttpStatus.OK);

	}

	@ApiOperation(value = "Get User Details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list", response = Object.class),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "{diagnosticId}/User", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getUserDetails(@PathVariable Long diagnosticId, @RequestParam String userId)
			throws JsonParseException, JsonMappingException, IOException {

		Diagnostics diagnostics = genericFactory.createDiagnostics(diagnosticId);
		UserInfoResponse response = diagnostics.getUserDetails(userId);
		if (response == null) {
			return new ResponseEntity<>((responseUtil.generateNoAPIResponse()), HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<>((response), HttpStatus.OK);

	}

	@ApiOperation(value = "Get the Order Details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list", response = Object.class),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "{diagnosticId}/order", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getOrderDetails(@PathVariable Long diagnosticId, @RequestParam String orderId)
			throws JsonParseException, JsonMappingException, IOException {

		Diagnostics diagnostics = genericFactory.createDiagnostics(diagnosticId);
		Object response = diagnostics.getOrderDetails(orderId);
		if (response == null) {
			return new ResponseEntity<>((responseUtil.generateNoAPIResponse()), HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<>((response), HttpStatus.OK);

	}

	@ApiOperation(value = "Track Order")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list", response = Object.class),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "{diagnosticId}/trackOrder", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> trackOrder(@PathVariable Long diagnosticId, @RequestParam String orderId)
			throws JsonParseException, JsonMappingException, IOException, DatatypeConfigurationException {

		Diagnostics diagnostics = genericFactory.createDiagnostics(diagnosticId);
		TrackOrderInfoResponse response = diagnostics.trackOrder();
		if (response == null) {
			return new ResponseEntity<>((responseUtil.generateNoAPIResponse()), HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<>((response), HttpStatus.OK);

	}

	@ApiOperation(value = "Cancel Order")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list", response = Object.class),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "{diagnosticId}/cancelOrder", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> cancelOrder(@PathVariable Long diagnosticId,
			@RequestBody CancelOrderRequest cancelOrderRequest)
			throws JsonParseException, JsonMappingException, IOException, DatatypeConfigurationException {

		Diagnostics diagnostics = genericFactory.createDiagnostics(diagnosticId);
		CancelOrderInfoResponse response = diagnostics.cancelOrder();
		if (response == null) {
			return new ResponseEntity<>((responseUtil.generateNoAPIResponse()), HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<>((response), HttpStatus.OK);

	}

	@ApiOperation(value = "Fetch Cancel Order Reasons")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list", response = Object.class),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "{diagnosticId}/cancelOrderReasons", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> cancelOrderReasons(@PathVariable Long diagnosticId)
			throws JsonParseException, JsonMappingException, IOException, DatatypeConfigurationException {

		Diagnostics diagnostics = genericFactory.createDiagnostics(diagnosticId);
		CancelOrderReasonsInfoResponse[] response = diagnostics.getCancelOrderReasons();
		if (response == null) {
			return new ResponseEntity<>((responseUtil.generateNoAPIResponse()), HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<>((response), HttpStatus.OK);

	}

	@ApiOperation(value = "Reschedule Order")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list", response = Object.class),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "{diagnosticId}/rescheduleOrder", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> rescheduleOrder(@PathVariable Long diagnosticId,
			@RequestBody RescheduleOrderRequest rescheduleOrderRequest)
			throws JsonParseException, JsonMappingException, IOException, DatatypeConfigurationException {

		Diagnostics diagnostics = genericFactory.createDiagnostics(diagnosticId);
		RescheduleOrderInfoResponse response = diagnostics.rescheduleOrder();
		if (response == null) {
			return new ResponseEntity<>((responseUtil.generateNoAPIResponse()), HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<>((response), HttpStatus.OK);

	}

	@ApiOperation(value = "Reschedule reasons")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list", response = Object.class),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "{diagnosticId}/rescheduleReasons", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> saveRescheduleReasons(@PathVariable Long diagnosticId, @RequestParam String orderId)
			throws JsonParseException, JsonMappingException, IOException, DatatypeConfigurationException {

		Diagnostics diagnostics = genericFactory.createDiagnostics(diagnosticId);
		RescheduleReasonsInfoResponse response = diagnostics.saveRescheduleReasons();
		if (response == null) {
			return new ResponseEntity<>((responseUtil.generateNoAPIResponse()), HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<>((response), HttpStatus.OK);

	}

	@ApiOperation(value = "get the specific order report")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list", response = Object.class),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "{diagnosticId}/reports", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getResultReport(@PathVariable Long diagnosticId, @RequestParam String orderId) {

//		resultReport.setPORDERNO("ATE000162");
		Diagnostics diagnostics = genericFactory.createDiagnostics(diagnosticId);
		Object response = diagnostics.getReport(orderId);
		if (response == null) {
			return new ResponseEntity<>((responseUtil.generateNoAPIResponse()), HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<>((response), HttpStatus.OK);

	}

}