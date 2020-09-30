package com.example.genericrestapi.healthplix.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PrescriptionResponse {

	public String hplx_appointment_id;
	public String hplx_doc_id;
	public String policy_id;
	public Object rx_raw;
	public String rx_pdf;
	public String rx_date;

	public static class RxRaw {
	}

}
