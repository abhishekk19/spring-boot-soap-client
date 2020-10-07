package com.example.genericrestapi.test.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.genericrestapi.config.RestService;
import com.example.genericrestapi.request.UserDetails;
import com.example.genericrestapi.response.LabInfo;
import com.example.genericrestapi.response.LabsInfoResponse;
import com.example.genericrestapi.response.UserInfoResponse;
import com.example.genericrestapi.service.CallHealthDiagnosticService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RunWith(MockitoJUnitRunner.class)
public class CallHealthDiagnosticServiceTest {

	@InjectMocks
	CallHealthDiagnosticService diagnosticService;

	@Mock
	RestService restService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getLabs_success() throws JsonMappingException, JsonProcessingException {
		LabsInfoResponse labsInfoResponse = new LabsInfoResponse();
		labsInfoResponse.setStatusCode(200);
		LinkedHashMap<String, LabInfo> map = new LinkedHashMap<>();
		LabInfo labInfo = new LabInfo();
		labInfo.setName("test lab");
		map.put("name", labInfo);
		labsInfoResponse.setLab(map);
		when(restService.postServiceCall(Mockito.anyObject(), Mockito.anyString(), Mockito.anyObject()))
				.thenReturn(map);
		LabsInfoResponse res = diagnosticService.getLabs(1.0, 1.0);
		assertEquals("test lab", res.getLab().get("name").getName());
//		assertEquals("Query Successful", res.getMsg());
//		assertEquals("ACCEPTED", res.getData());

	}

	@Test
	public void getUserDetails_success() throws JsonMappingException, JsonProcessingException {
		UserInfoResponse userInfoResponse = new UserInfoResponse();
		userInfoResponse.setStatus("success");
		List<UserDetails> list = new ArrayList<UserDetails>();
		UserDetails userDetails = new UserDetails();
		userDetails.setFirstName("Ram");
		list.add(userDetails);
		userInfoResponse.setDataObject(list);
		when(restService.postServiceCall(Mockito.anyObject(), Mockito.anyString(), Mockito.anyObject()))
				.thenReturn(userInfoResponse);
		UserInfoResponse res = diagnosticService.getUserDetails("drl123");
		assertEquals("Ram", res.getDataObject().get(0).getFirstName());
		assertEquals("success", res.getStatus());
//		assertEquals("ACCEPTED", res.getData());

	}

}
