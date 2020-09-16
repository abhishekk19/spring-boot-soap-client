package com.example.genericrestapi.response;

import java.util.List;

public class CancelOrderInfoResponse {
	
    public String status;
    public List<Msg> msg;
    
	public static class ChissResponse{
	    public int status;
	    public String message;
	}

	public static class Msg{
	    public String response;
	    public String msg;
	    public List<ChissResponse> chiss_response;
	}


}
