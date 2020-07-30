package com.example.genericrestapi.config;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;


public class SOAPConnector extends WebServiceGatewaySupport {

	public Object callWebService(String url, Object request, String soapAction){
		return getWebServiceTemplate().marshalSendAndReceive(url, request,webServiceMessage -> {
            (( SoapMessage )webServiceMessage).setSoapAction(soapAction);
        } );
	}
}