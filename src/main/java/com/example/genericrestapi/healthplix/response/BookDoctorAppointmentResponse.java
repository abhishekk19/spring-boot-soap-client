package com.example.genericrestapi.healthplix.response;

public class BookDoctorAppointmentResponse {

	public String hplx_appointment_id;
	public String hplx_doc_id;
	public String policy_id;
	public String status;
	public AppointmentDetails appointment_details;

	public static class AppointmentDetails {
		public String appointment_date;
		public String appointment_time;
		public String appointment_type;
	}

}
