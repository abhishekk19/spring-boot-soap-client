package com.example.genericrestapi.request;

import com.example.genericrestapi.request.UserDetailsRequest.Request;

public class CallHealthApiRequest {
	
	private static final String USER_DETAILS_METHOD = "globalmaster/gcm/corporate/customer/fullDetails";
	private static final String POST_TYPE ="POST";
	private static final String APPLICATION = "gcm";
	
	public UserDetailsRequest prepareUserDetailsRequest(String mrnId) {
		UserDetailsRequest userDetailsRequest = new UserDetailsRequest();
		UserDetailsRequest.Request request = new Request();
		userDetailsRequest.setMethod(USER_DETAILS_METHOD);
		userDetailsRequest.setType(POST_TYPE);
		userDetailsRequest.setApplication(APPLICATION);
		request.setMrn(mrnId);
		userDetailsRequest.setRequest(request);
		return userDetailsRequest;
	}

}
