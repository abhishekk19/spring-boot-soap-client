package com.example.genericrestapi.response;

import java.util.Date;

public class RegisterUserInfoResponse {
	
    public DataObject dataObject;
    public String reason;
    public int statusCode;
    public String status;
    
	public class DataObject{
	    public Object authMrn;
	    public Object accessToken;
	    public Object source;
	    public Date createdDate;
	    public Date modifiedDate;
	    public int customerMRNID;
	    public String mrn;
	    public String firstName;
	    public String lastName;
	    public String middleName;
	    public String userName;
	    public String salutation;
	    public String email;
	    public String mobile;
	    public Object alternateEmail;
	    public Object alternateMobile;
	    public String dob;
	    public int age;
	    public String gender;
	    public String profilePicPath;
	    public int isActive;
	    public Object sourceType;
	    public int sourceId;
	    public int consent;
	    public int isDependent;
	    public Object businessSource;
	    public Object parentMrn;
	    public Object relation;
	    public String tenantCode;
	    public String organizationCode;
	    public String memberId;
	    public String memberEmail;
	    public String designation;
	    public Object walletBalance;
	    public String createdBy;
	    public Object modifiedBy;
	    public Object otpExternal;
	}
}
