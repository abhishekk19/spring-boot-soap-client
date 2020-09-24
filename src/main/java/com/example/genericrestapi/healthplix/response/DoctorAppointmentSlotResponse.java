package com.example.genericrestapi.healthplix.response;

import java.util.List;
import java.util.Map;

public class DoctorAppointmentSlotResponse {

	public String slot_duration;
	public Map<String, List<SlotDate>> slots;

	public static class SlotDate {
		public String start_time;
		public String end_time;
		public String status;
	}

}
