package com.example.genericrestapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.genericrestapi.factory.GenericFactory;
import com.example.genericrestapi.factory.Prescription;
import com.example.genericrestapi.healthplix.response.AppointmentDetailsResponse;
import com.example.genericrestapi.healthplix.response.BookDoctorAppointmentResponse;
import com.example.genericrestapi.healthplix.response.DoctorAppointmentSlotResponse;
import com.example.genericrestapi.healthplix.response.DoctortDetailsResponse;
import com.example.genericrestapi.healthplix.response.GenerateOtpResponse;
import com.example.genericrestapi.healthplix.response.PrescriptionResponse;
import com.example.genericrestapi.healthplix.response.ValidateOtpResponse;
import com.example.genericrestapi.util.ResponseUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {

	@Autowired
	GenericFactory genericFactory;

	@Autowired
	ResponseUtil responseUtil ;

	@ApiOperation(value = "get Doctor Slots", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved "),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "{partnerId}/slots", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getDoctorSlots(@PathVariable Long partnerId, @RequestParam String docId,
			@RequestParam String date, @RequestParam String bookingType)
			throws JsonMappingException, JsonProcessingException {

		Prescription prescription = genericFactory.createPrescriptions(partnerId);
		DoctorAppointmentSlotResponse response = prescription.getDoctorSlots();
		if (response == null) {
			return new ResponseEntity<>((responseUtil.generateNoAPIResponse()), HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<>((responseUtil.generateGenericResponse(response, ResponseUtil.getMessage)),
				HttpStatus.OK);
	}

	@ApiOperation(value = "Book Doctor Appointment", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved "),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "{partnerId}/doctor-appointment", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> bookDoctorAppointment(@PathVariable Long partnerId)
			throws JsonMappingException, JsonProcessingException {
		Prescription prescription = genericFactory.createPrescriptions(partnerId);
		BookDoctorAppointmentResponse response = prescription.bookDoctorAppointment();
		if (response == null) {
			return new ResponseEntity<>((responseUtil.generateNoAPIResponse()), HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<>((responseUtil.generateGenericResponse(response, ResponseUtil.postMessage)),
				HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "validate generated Otp", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved "),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "{partnerId}/validate-otp/", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> validateOtp(@PathVariable Long partnerId , @RequestParam String policyId , @RequestParam String otp)
			throws JsonMappingException, JsonProcessingException {
		Prescription prescription = genericFactory.createPrescriptions(partnerId);
		ValidateOtpResponse response = prescription.validateOtp();
		if (response == null) {
			return new ResponseEntity<>((responseUtil.generateNoAPIResponse()), HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<>((responseUtil.generateGenericResponse(response, ResponseUtil.postMessage)),
				HttpStatus.OK);
	}
	
	@ApiOperation(value = "Generated Otp to validate Patient", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved "),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "{partnerId}/generate-otp", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> generateOtp(@PathVariable Long partnerId , @RequestParam String policyId , @RequestParam String sendOtp)
			throws JsonMappingException, JsonProcessingException {
		Prescription prescription = genericFactory.createPrescriptions(partnerId);
		GenerateOtpResponse response = prescription.generateOtp();
		if (response == null) {
			return new ResponseEntity<>((responseUtil.generateNoAPIResponse()), HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<>((responseUtil.generateGenericResponse(response, ResponseUtil.postMessage)),
				HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "get Prescription", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved "),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "{partnerId}/prescription", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getPrescription(@PathVariable Long partnerId , @RequestParam String docId , @RequestParam String appointmentId)
			throws JsonMappingException, JsonProcessingException {
		Prescription prescription = genericFactory.createPrescriptions(partnerId);
		PrescriptionResponse response = prescription.getPrescription();
		if (response == null) {
			return new ResponseEntity<>((responseUtil.generateNoAPIResponse()), HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<>((responseUtil.generateGenericResponse(response, ResponseUtil.getMessage)),
				HttpStatus.OK);
	}
	
	@ApiOperation(value = "get Appointment Details", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved "),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "{partnerId}/appointment", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getAppointmentDetails(@PathVariable Long partnerId , @RequestParam String docId , @RequestParam String appointmentId)
			throws JsonMappingException, JsonProcessingException {
		Prescription prescription = genericFactory.createPrescriptions(partnerId);
		AppointmentDetailsResponse response = prescription.getAppointmentDetails();
		if (response == null) {
			return new ResponseEntity<>((responseUtil.generateNoAPIResponse()), HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<>((responseUtil.generateGenericResponse(response, ResponseUtil.getMessage)),
				HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "get Doctor Details", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved "),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "{partnerId}/doctor", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getDoctorDetails(@PathVariable Long partnerId , @RequestParam String docId , @RequestParam String empanelment_id )
			throws JsonMappingException, JsonProcessingException {
		Prescription prescription = genericFactory.createPrescriptions(partnerId);
		DoctortDetailsResponse response = prescription.getDoctortDetails();
		if (response == null) {
			return new ResponseEntity<>((responseUtil.generateNoAPIResponse()), HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<>((responseUtil.generateGenericResponse(response, ResponseUtil.getMessage)),
				HttpStatus.OK);
	}

}
