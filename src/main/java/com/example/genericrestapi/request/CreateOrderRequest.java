package com.example.genericrestapi.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateOrderRequest {
	
    public int corporateId;
    public String dateOfSharingData;
    public int mrn;
    public String tests;
    public String chTests;
    public int business;
    public String codes;
    public int status;
    public int orderStatus;
    public String applicationNumber;
    public String mobileNumber;
    public String name;
    public String state;
    public String city;
    public String createdBy;
    public String modifiedBy;
    public String caseRegisteredDate;
    public String lastStatusChangeDate;
    public boolean isVideoMer;
    public String createdDateStr;
    public int roleId;
    public int branchId;
    public int engagedBy;
    public boolean uploadFlag;
    public int nodeId;
    public String packageCode;
    public String statusStr;
    public int pendingCallCount;
    public int totalCallCount;
    @JsonProperty("ID") 
    public int iD;
    public boolean enabled;
    public DateCreated dateCreated;
    public DateModified dateModified;
    public String $$hashKey;
    public String selectedMHOTimeSlot;
    public String selectedTimeSlot;
    public String reorder;
    public String transactionID;
    public String mhoTransactionID;
    public String selectedPostTimeSlot;
    public double order_latitude;
    public double order_longitude;
    public String businessType;
    public int timeslots;
    public String addressHDFC;
    public String schedulePastDate;
    public String posttime;
    public Addressobj addressobj;
    public String scheduleDate;
    public int corporateID;
    public boolean fasttest;
    public boolean orderType;
    @JsonProperty("LatVal") 
    public double latVal;
    @JsonProperty("LngVal") 
    public double lngVal;
    @JsonProperty("LadMark") 
    public String ladMark;
    public String pincode;
    public String vendorData;
	

	public class DateCreated{
	    public int year;
	    public int month;
	    public int dayOfMonth;
	    public int hourOfDay;
	    public int minute;
	    public int second;
	}

	public class DateModified{
	    public int year;
	    public int month;
	    public int dayOfMonth;
	    public int hourOfDay;
	    public int minute;
	    public int second;
	}

	public class Addressobj{
	    public String district;
	    public String countryVal;
	    public String areaVal;
	    public String cityVal;
	    public String zipcodeVal;
	    public String stateVal;
	    public String landmark;
	    @JsonProperty("LatVal") 
	    public double latVal;
	    @JsonProperty("LngVal") 
	    public double lngVal;
	    public String addressHDFC;
	}
}
