package com.example.genericrestapi.response;

import java.util.Date;

public class RegisterUserAddressInfoResponse {
	
    public String status;
    public int statusCode;
    public DataObject dataObject;
    public String reason;
    
	public class DataObject{
	    public Object authMrn;
	    public Object accessToken;
	    public Object source;
	    public Date createdDate;
	    public Date modifiedDate;
	    public int customerAddrID;
	    public String customerMRNID;
	    public String addressType;
	    public int isDefaultAddress;
	    public String country;
	    public String state;
	    public String district;
	    public String mandal;
	    public String city;
	    public String address;
	    public String area;
	    public String landmark;
	    public String zipcode;
	    public String latitude;
	    public String longitude;
	    public int enabled;
	    public String createdBy;
	    public Object modifiedBy;
	}
}
