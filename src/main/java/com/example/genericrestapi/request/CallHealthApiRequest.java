package com.example.genericrestapi.request;

import com.example.genericrestapi.response.RegisterUserInfoResponse;

public class CallHealthApiRequest {

	private static final String USER_DETAILS_METHOD = "globalmaster/gcm/corporate/customer/fullDetails";
	private static final String LABS_METHOD = "corporate/services/drReddy/associatesByServiceCodes";
	private static final String SLOTS_METHOD = "api/officer_slots";
	private static final String USER_REGISTRATION_METHOD = "globalmaster/gcm/corporate/customer/createCustomer";

	private static final String POST_TYPE = "POST";
	private static final String GCM_APPLICATION = "gcm";
	private static final String IHS_APPLICATION = "ihs";
	private static final String CHISS_APPLICATION = "chiss";
	private static final String organizationCode = "100229";
	private static final String tenantCode = "1000143";
	private static final int businessId = 3;
	private static final String service_item_code = "DRL00001,DRL00001";

	public UserDetailsRequest prepareUserDetailsRequest(String mrnId) {
		UserDetailsRequest userDetailsRequest = new UserDetailsRequest();
		UserDetailsRequest.Data request = userDetailsRequest.new Data();
		userDetailsRequest.setMethod(USER_DETAILS_METHOD);
		userDetailsRequest.setType(POST_TYPE);
		userDetailsRequest.setApplication(GCM_APPLICATION);
		request.setMrn(mrnId);
		userDetailsRequest.setRequest(request);
		return userDetailsRequest;
	}

	public LabsInfoRequest prepareLabsInfoRequest(Double latitude, Double longitude) {
		LabsInfoRequest labsInfoRequest = new LabsInfoRequest();
		LabsInfoRequest.Data request = labsInfoRequest.new Data();
		labsInfoRequest.setMethod(LABS_METHOD);
		labsInfoRequest.setType(POST_TYPE);
		labsInfoRequest.setApplication(IHS_APPLICATION);
		request.setLatitude(latitude);
		request.setLongitude(longitude);
		request.setOrganizationCode(organizationCode);
		request.setService_item_code(service_item_code);
		request.setTenantCode(tenantCode);
		labsInfoRequest.setRequest(request);
		return labsInfoRequest;
	}

	public PhleboSlotsRequest preparePhleboSlotsRequest(String latitude, String longitude, String fromDate,
			String toDate, int patientAge, String pincode, String serviceDid, String patientGender) {
		PhleboSlotsRequest phleboSlotsRequest = new PhleboSlotsRequest();
		SlotRequest request = new SlotRequest();
		phleboSlotsRequest.setMethod(SLOTS_METHOD);
		phleboSlotsRequest.setType(POST_TYPE);
		phleboSlotsRequest.setApplication(CHISS_APPLICATION);
		request.setOrderLatitude(latitude);
		request.setOrderLongitude(longitude);
		request.setOrganizationCode(organizationCode);
		request.setTenantCode(tenantCode);
		request.setFromDate(fromDate);
		request.setToDate(toDate);
		request.setBusinessId(businessId);
		request.setPatientAge(patientAge);
		request.setPincode(pincode);
		request.setServiceDid(serviceDid);
		request.setPatientGender(patientGender);
		request.setEngagementLevel(1);
		phleboSlotsRequest.setRequest(request);
		return phleboSlotsRequest;
	}

	public RegisterUserRequest prepareRegisterUserRequest(RegisterUserRequest registerUserRequest) {
		//RegisterUserRequest registerUserRequest = new RegisterUserRequest();
		RegisterUserRequest.Request request = registerUserRequest.getRequest();
		registerUserRequest.setMethod(USER_REGISTRATION_METHOD);
		registerUserRequest.setType(POST_TYPE);
		registerUserRequest.setApplication(GCM_APPLICATION);
		request.setEnabled(1);
		request.setIsActive(1);
		request.setSourceType("CORP");
		return registerUserRequest;
	}

}
