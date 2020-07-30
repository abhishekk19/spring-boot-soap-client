package com.example.genericrestapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.genericrestapi.factory.DiagnosticsFactory;

@Configuration
public class FactoryBeanAppConfig {
 
    @Bean(name = "Diagnostics")
    public DiagnosticsFactory diagnosticsFactory() {
    	return new DiagnosticsFactory();
    }
    
//    @Bean(name = "SRLDiagnostics")
//    public SRLDiagnostics srlDiagnostics() {
//    	SRLDiagnostics srlDiagnostics = new SRLDiagnostics();
//        return srlDiagnostics;
//    }
 
}
