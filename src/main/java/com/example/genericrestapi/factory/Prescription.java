package com.example.genericrestapi.factory;

import com.example.genericrestapi.healthplix.response.BookDoctorAppointmentResponse;
import com.example.genericrestapi.healthplix.response.DoctorAppointmentSlotResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface Prescription {

	DoctorAppointmentSlotResponse getDoctorSlots() throws JsonMappingException, JsonProcessingException;

	BookDoctorAppointmentResponse bookDoctorAppointment() throws JsonMappingException, JsonProcessingException;

}
