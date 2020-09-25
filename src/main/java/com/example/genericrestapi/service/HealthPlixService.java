package com.example.genericrestapi.service;

import org.springframework.stereotype.Service;

import com.example.genericrestapi.factory.Prescription;
import com.example.genericrestapi.healthplix.response.BookDoctorAppointmentResponse;
import com.example.genericrestapi.healthplix.response.DoctorAppointmentSlotResponse;
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


}
