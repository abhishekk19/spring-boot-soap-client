package com.example.genericrestapi.request;

import java.util.List;

public class OrderDetailsRequest {

	public String orderDid;
	public int orderId;
	public String channelCode;
	public String actionById;
	public List<TenantOrgInfo> tenantOrgInfo;

	public static class TenantOrgInfo {
		public String tenantCode;
		public String orgCode;
	}

}
