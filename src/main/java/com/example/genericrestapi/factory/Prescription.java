package com.example.genericrestapi.factory;

import com.example.genericrestapi.healthplix.response.AppointmentDetailsResponse;
import com.example.genericrestapi.healthplix.response.BookDoctorAppointmentResponse;
import com.example.genericrestapi.healthplix.response.DoctorAppointmentSlotResponse;
import com.example.genericrestapi.healthplix.response.GenerateOtpResponse;
import com.example.genericrestapi.healthplix.response.PrescriptionResponse;
import com.example.genericrestapi.healthplix.response.ValidateOtpResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface Prescription {

	DoctorAppointmentSlotResponse getDoctorSlots() throws JsonMappingException, JsonProcessingException;

	BookDoctorAppointmentResponse bookDoctorAppointment() throws JsonMappingException, JsonProcessingException;

	ValidateOtpResponse validateOtp() throws JsonMappingException, JsonProcessingException;

	GenerateOtpResponse generateOtp() throws JsonMappingException, JsonProcessingException;

	PrescriptionResponse getPrescription() throws JsonMappingException, JsonProcessingException;

	AppointmentDetailsResponse getAppointmentDetails() throws JsonMappingException, JsonProcessingException;

	
}
