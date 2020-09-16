package com.example.genericrestapi.response;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PhleboSlotsinfoResponse {
	
    public int status;
    public Map<String, List<SlotDate>> slots;
    
    
    public static class SlotDate {
        public String from_time;
        public String to_time;
        public String transaction_id;
        public int is_booked;
    }
	
}
