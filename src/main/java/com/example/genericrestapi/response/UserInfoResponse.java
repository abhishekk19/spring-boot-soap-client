package com.example.genericrestapi.response;

import java.util.List;

public class UserInfoResponse {

	public String status;
	public int statusCode;
	public List<DataObject> dataObject;

	public static class DataObject {
		public int customerMRNID;
		public String firstName;
		public String lastName;
		public String middleName;
		public String userName;
		public String salutation;
		public String email;
		public String mobile;
		public String dob;
		public int age;
		public String gender;
		public String profilePicPath;
		public int isActive;
		public String sourceType;
		public int sourceId;
		public int consent;
		public int isDependent;
		public Object parentMrn;
		public Object relation;
		public String tenantCode;
		public String organizationCode;
		public String memberId;
		public Object memberEmail;
		public String designation;
		public int customerAddrID;
		public Object addressType;
		public int isDefaultAddress;
		public Object country;
		public Object state;
		public Object district;
		public Object mandal;
		public Object city;
		public Object address;
		public Object area;
		public Object landmark;
		public Object zipcode;
		public Object latitude;
		public Object longitude;
	}

	public String reason;

}
