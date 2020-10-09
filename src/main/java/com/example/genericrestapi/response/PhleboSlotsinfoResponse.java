package com.example.genericrestapi.response;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.example.genericrestapi.response.PhleboSlotsinfoResponse.SlotDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PhleboSlotsinfoResponse {

	@JsonProperty("status")
	private int status;

	@JsonProperty("slots")
	private LinkedHashMap<String, SlotDate> slots;

	public class SlotDate {

		@JsonProperty("from_time")
		private String fromTime;

		@JsonProperty("to_time")
		private String toTime;

		@JsonProperty("transaction_id")
		private String transactionId;

		@JsonProperty("is_booked")
		private int isBooked;

		public String getFromTime() {
			return fromTime;
		}

		public void setFromTime(String fromTime) {
			this.fromTime = fromTime;
		}

		public String getToTime() {
			return toTime;
		}

		public void setToTime(String toTime) {
			this.toTime = toTime;
		}

		public String getTransactionId() {
			return transactionId;
		}

		public void setTransactionId(String transactionId) {
			this.transactionId = transactionId;
		}

		public int getIsBooked() {
			return isBooked;
		}

		public void setIsBooked(int isBooked) {
			this.isBooked = isBooked;
		}

	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public LinkedHashMap<String, SlotDate> getSlots() {
		return slots;
	}

	public void setSlots(LinkedHashMap<String, SlotDate> slots) {
		this.slots = slots;
	}

}
