package com.example.genericrestapi.response;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PhleboSlotsinfoResponse {
	
    public int status;
    public Object slots;
	
}
