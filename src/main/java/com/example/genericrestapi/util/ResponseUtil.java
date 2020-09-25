package com.example.genericrestapi.util;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.example.genericrestapi.response.Response;

@Component
public class ResponseUtil {

	public static String postMessage = "Request processed successfully";

	public static String getMessage = "Data fetched successfully";

	
	public Response generateNoAPIResponse() {
		Response response = new Response();
		response.setReason("Service is currently unavaiable from the partner");
		response.setStatus(HttpStatus.SERVICE_UNAVAILABLE);
		response.setStatusCode(HttpStatus.SERVICE_UNAVAILABLE.value());
		return response;
	}

	public Response generateGenericResponse(Object response, String reason) {
		Response res = new Response();
		res.setReason(reason);
		res.setStatus(HttpStatus.OK);
		res.setStatusCode(HttpStatus.OK.value());
		res.setData(response);
		return res;
	}

}
