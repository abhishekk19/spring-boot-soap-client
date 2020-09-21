package com.example.genericrestapi.factory;

public interface BaseFactory {

	public Diagnostics createDiagnostics(Long type);
	
	public Prescription createPrescriptions(Long type);


}
