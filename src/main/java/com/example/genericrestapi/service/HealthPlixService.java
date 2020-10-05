package com.example.genericrestapi.service;

import org.springframework.stereotype.Service;

import com.example.genericrestapi.factory.Prescription;
import com.example.genericrestapi.healthplix.response.AppointmentDetailsResponse;
import com.example.genericrestapi.healthplix.response.BookDoctorAppointmentResponse;
import com.example.genericrestapi.healthplix.response.DoctorAppointmentSlotResponse;
import com.example.genericrestapi.healthplix.response.DoctortDetailsResponse;
import com.example.genericrestapi.healthplix.response.GenerateOtpResponse;
import com.example.genericrestapi.healthplix.response.PrescriptionResponse;
import com.example.genericrestapi.healthplix.response.ValidateOtpResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class HealthPlixService implements Prescription {

	@Override
	public DoctorAppointmentSlotResponse getDoctorSlots() throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		String json = "{ \"slot_duration\":\"30\",\"slots\":{\"session-1\":[{\"start_time\":\"7:00 AM\",\"end_time\":\"7:30 AM\",\"status\":\"available\"},{\"start_time\":\"8:30 AM\",\"end_time\":\"9:00 AM\",\"status\":\"available\"}],\"session-2\":[{\"start_time\":\"1:00 PM\",\"end_time\":\"1:30 PM\",\"status\":\"available\"},{\"start_time\":\"1:30 PM\",\"end_time\":\"2:00 PM\",\"status\":\"available\"},{\"start_time\":\"2:30 PM\",\"end_time\":\"3:00 PM\",\"status\":\"available\"}]} }";
		DoctorAppointmentSlotResponse response = objectMapper.readValue(json, DoctorAppointmentSlotResponse.class);

		return response;
	}
	
	
	@Override
	public BookDoctorAppointmentResponse bookDoctorAppointment() throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		String json = "{\r\n" + 
				"   \"hplx_appointment_id\":\"\",\r\n" + 
				"   \"hplx_doc_id\":\"\",\r\n" + 
				"   \"policy_id\":\"\",\r\n" + 
				"   \"status\":\"slot-na/booked/error\",\r\n" + 
				"   \"appointment_details\":{\r\n" + 
				"      \"appointment_date\":\"\",\r\n" + 
				"      \"appointment_time\":\"\",\r\n" + 
				"      \"appointment_type\":\"\"\r\n" + 
				"   }\r\n" + 
				"}";
		BookDoctorAppointmentResponse response = objectMapper.readValue(json, BookDoctorAppointmentResponse.class);

		return response;
	}
	
	
	@Override
	public ValidateOtpResponse validateOtp() throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		String json = "{ \"status\" :\"authenticated\", \"event_id\": \"\" , \"policy_id\":\"1234\"}";
		ValidateOtpResponse response = objectMapper.readValue(json, ValidateOtpResponse.class);

		return response;
	}
	
	
	@Override
	public GenerateOtpResponse generateOtp() throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		String json = "{ \"patient_details\" : { \"name\" : \"Alex\", \"gender\" : \"M\", \"dob\" : \"\"} , \"otp_status\" : \"sent/not-sent\"}";
		GenerateOtpResponse response = objectMapper.readValue(json, GenerateOtpResponse.class);

		return response;
	}

	@Override
	public PrescriptionResponse getPrescription() throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		String json = "{ \"hplx_appointment_id\" : \"\" ,\"hplx_doc_id\":\"\", \"policy_id\": \"\" , \"rx_raw\" : {} , \"rx_pdf\" : \"url\" , \"rx_date\":\"\" }";
		PrescriptionResponse response = objectMapper.readValue(json, PrescriptionResponse.class);

		return response;
	}
	
	
	@Override
	public AppointmentDetailsResponse getAppointmentDetails() throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		String json = "{ \"hplx_appointment_id\" : \"\" , \"hplx_doc_id\" :\"\" , \"policy_id\" :\"\" , \"status\" : \"cancelled/confirmed\" , \"appointment_details\" : { \"appointment_date\" : \"\" , \"appointment_time\" : \"\" , \"appointment_type\" : \"\" } } \r\n" + 
				"";
		AppointmentDetailsResponse response = objectMapper.readValue(json, AppointmentDetailsResponse.class);

		return response;
	}

	
	@Override
	public DoctortDetailsResponse getDoctortDetails() throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		String json = "{\"hplx_doc_id\":\"\", \"doc_name\" :\"\", \"speciality\" : \"\", \"lat\" : \"\", \"longt\" : \"\", \"clinic_name\" :\"\", \"consultation_fee\" :\"\", \"last_modified\" : \"\" , \"Address\" : \"\" , \"pincode\" :\"\" , \"phone\" : \"\", \"email\" : \"\" , \"status\" : \"\"}";
		DoctortDetailsResponse response = objectMapper.readValue(json, DoctortDetailsResponse.class);

		return response;
	}


}
