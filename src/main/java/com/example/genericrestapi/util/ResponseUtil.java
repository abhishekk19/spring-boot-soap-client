package com.example.genericrestapi.util;

import org.springframework.http.HttpStatus;

import com.example.genericrestapi.response.Response;

public class ResponseUtil {

	public Response generateNoAPIResponse() {
		Response response = new Response();
		response.setReason("Service is currently unavaiable from the partner");
		response.setStatus(HttpStatus.SERVICE_UNAVAILABLE);
		response.setStatusCode(503);

		return response;
	}

}
