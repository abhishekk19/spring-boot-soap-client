package com.example.genericrestapi.healthplix.response;

public class GenerateOtpResponse {

	public PatientDetails patient_details;
	public String otp_status;

	public class PatientDetails {
		public String name;
		public String gender;
		public String dob;
	}

}
