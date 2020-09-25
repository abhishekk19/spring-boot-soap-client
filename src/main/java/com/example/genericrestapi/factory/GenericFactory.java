package com.example.genericrestapi.factory;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.genericrestapi.service.CallHealthDiagnosticService;
import com.example.genericrestapi.service.HealthPlixService;
import com.example.genericrestapi.service.SRLDiagnosticService;

public class GenericFactory implements BaseFactory {

	@Autowired
	private SRLDiagnosticService srlDiagnosticService;
	
	@Autowired
	private CallHealthDiagnosticService callHealthDiagnosticService;
	
	@Autowired
	private HealthPlixService healthPlixService;

	@Override
	public Diagnostics createDiagnostics(Long type) {
		Diagnostics diagnostics;
		switch (type.intValue()) {
		case 1:// SRL
			diagnostics = srlDiagnosticService;
			break;
            case 2:
            	diagnostics = callHealthDiagnosticService;
                break;
//            case 3:
//            	diagnostics =  srlDiagnosticService;
//                break;
		default:
			throw new IllegalArgumentException("No such Diagnostics");
		}
		return diagnostics;
	}

	@Override
	public Prescription createPrescriptions(Long type) {
		Prescription prescription = null;
		switch (type.intValue()) {
		case 1:
			prescription = healthPlixService;
			break;
//            case 2:
//            	prescription = MfineService;
//                break;
		default:
			throw new IllegalArgumentException("No such Prescriptions");
		}
		
		return prescription;
	}

}
