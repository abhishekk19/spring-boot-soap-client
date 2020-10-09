package com.example.genericrestapi.request;

import java.util.List;

public class RegisterUserRequest {

	public String method;
	public String type;
	public String application;
	public Request request;

	public class Request {
		public String firstName;
		public String lastName;
		public String middleName;
		public String salutation;
		public String userName;
		public String gender;
		public String profilePicPath;
		public String dob;
		public String email;
		public String mobile;
		public int enabled;
		public int isActive;
		public String sourceType;
		public String password;
		public String createdBy;
		public String organizationCode;
		public String tenantCode;
		public String memberId;
		public String memberEmail;
		public String designation;
		public List<Address> address;
	}

}
