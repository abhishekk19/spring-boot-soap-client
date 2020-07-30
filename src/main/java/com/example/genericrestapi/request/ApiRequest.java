package com.example.genericrestapi.request;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.example.genericrestapi.createOrder.CreateOrderOPT;
import com.example.genericrestapi.createOrder.GetOrderStatus;
import com.example.genericrestapi.createOrder.GetResultReportOPT;
import com.example.genericrestapi.response.CreateOrderRequest;
import com.example.genericrestapi.util.MD5Util;

public class ApiRequest {

	private final String DIAGNISTICS_SRL = "SRL";

	private final String groupType = "1";

	private final String source = "OPT";// dro

	private final String hardCopy = "Y";

	private final String pFlag = "I";

	public GetOrderStatus prepareGetOrderStatus(String orderId) {
		String keyString = orderId + "|" + DIAGNISTICS_SRL;
		GetOrderStatus orderStatusRequest = new GetOrderStatus();
		orderStatusRequest.setPORDERID(orderId);
		orderStatusRequest.setGrouptyp(groupType);
		orderStatusRequest.setSource(source);
		orderStatusRequest.setStrVldTk(MD5Util.generateMd5Key(keyString));
		return orderStatusRequest;
	}

	public GetResultReportOPT prepareResultReportOPT(String orderId) {
		String keyString = orderId + "|" + DIAGNISTICS_SRL;
		GetResultReportOPT resultReport = new GetResultReportOPT();
		resultReport.setGrouptyp(groupType);
		resultReport.setPORDERNO(orderId);
		resultReport.setPCITY("");
		resultReport.setPDEVICEID("");
		resultReport.setPDEVICETOKEN("");
		resultReport.setPOSVERSION("");
		resultReport.setPMOBILENO("");
		resultReport.setPEMAILID("");
		resultReport.setPOSTYPE("");
		resultReport.setPMYSRLVERSION("");
		resultReport.setPPTNTCD("");
		resultReport.setSource(source);
		resultReport.setStrVldTk(MD5Util.generateMd5Key(keyString));
		return resultReport;
	}

	public CreateOrderOPT prepareCreateOrderOPT(CreateOrderRequest createOrderRequest)
			throws DatatypeConfigurationException {

		XMLGregorianCalendar gregFmt = DatatypeFactory.newInstance()
				.newXMLGregorianCalendar(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date()));

		CreateOrderOPT createOrderOPT = new CreateOrderOPT();

		// Mandatory fields
		createOrderOPT.setPFLAG(pFlag);
		createOrderOPT.setPCOUNTRY("iNDIA");
		createOrderOPT.setPTESTS("100012423,100011534,100005133");
		createOrderOPT.setPTESTAMNTS("3000,5500,790");
		createOrderOPT.setPTESTNETAMNTS("3000,5500,790");
		createOrderOPT.setPTESTPTNTAMNTS("0,0,790");
		createOrderOPT.setPTESTCLNTAMNTS("3000");
		createOrderOPT.setPFIRSTNAME("Rupali");
		createOrderOPT.setPDOB("05-Aug-2020");
		createOrderOPT.setPGENDER("M");
		createOrderOPT.setPLABID("");

		// Mandatory fields
		createOrderOPT.setPSTATE("Madhya Pradesh");
		createOrderOPT.setPCOLLDATEFROM(gregFmt);
		createOrderOPT.setPCOLLDATETO(gregFmt);
		createOrderOPT.setPHARDCOPY(hardCopy);
		createOrderOPT.setPISEXTRATESTS("N,N,Y");
		createOrderOPT.setPPTNTNM("Rupali");
		createOrderOPT.setPGROSSAMT("9290");
		createOrderOPT.setPPTNTAMNT("9290");
		createOrderOPT.setPCLNTAMNT("8500");
		createOrderOPT.setPDISCOUNT("0");
		createOrderOPT.setPDISCOUNTFLAG("");
		createOrderOPT.setPDISCAMNTS("");
		createOrderOPT.setPDISCPERC("");
		createOrderOPT.setPDOBACTFLG("Y");
		createOrderOPT.setPCOLLTYPE("L");
		createOrderOPT.setGrouptyp(groupType);
		createOrderOPT.setPCCID("CS00002926");
		createOrderOPT.setSource(source);

		// Optional fields
//		createOrderOPT.setPORDERID("");
//		createOrderOPT.setPADDRESS("QWE");
//		createOrderOPT.setPLOCATION("Mumbai");
//		createOrderOPT.setPCITY("Mumbai");
//		createOrderOPT.setPZIP("");
//		createOrderOPT.setPPTNTCD("");
//		createOrderOPT.setPDOCTOR("DR");
//		createOrderOPT.setPCOLLCONTACT("12394823984");
//		createOrderOPT.setOstype("1");
//		createOrderOPT.setMysrlVersion("1.0.1");
//		createOrderOPT.setSurveyFlag("1");
//		createOrderOPT.setPMOBILENO("1234566789");
//		createOrderOPT.setPEMAILID("dell@gmail.com");
//		createOrderOPT.setPPTNTCD("");
//		createOrderOPT.setPCREATEDBY("");
//		createOrderOPT.setPPROMOCODE("");
//		createOrderOPT.setPPAYMODE("Offline");
//		createOrderOPT.setPPAYMENTOPT("CASH");
//		createOrderOPT.setPTITLE("");
//		createOrderOPT.setPLASTNAME("LAST STRING");
//		createOrderOPT.setRedeemPoints("0");
//		createOrderOPT.setActualPoints("0");
//		createOrderOPT.setPCUSTTYP("w");
//		createOrderOPT.setCAMPREQUESTID("000065");
//		createOrderOPT.setServiceCentreId("500000898");
//		createOrderOPT.setCAMPPONUMBER("10001");
//		createOrderOPT.setCAMPPOTOTALQTY("100");
//		createOrderOPT.setCAMPPOBALANCEQTY("20");
//		createOrderOPT.setCAMPCONTRACTSTARTDT(gregFmt);;
//		createOrderOPT.setCAMPCONTRACTENDDT(gregFmt);
//		createOrderOPT.setCAMPCLIENTTYP("CR");;
//		createOrderOPT.setCAMPPERFORMEDBY("C");

		createOrderOPT.setServiceCentreId("500000898");
		createOrderOPT.setCAMPPOTOTALQTY("0");
		createOrderOPT.setCAMPPOBALANCEQTY("0");

		String keyString = createOrderOPT.getPPTNTNM().toUpperCase() + "|" + createOrderOPT.getPGROSSAMT() + "|"
				+ DIAGNISTICS_SRL;

		createOrderOPT.setStrVldTk(MD5Util.generateMd5Key(keyString));

		return createOrderOPT;
	}

}
