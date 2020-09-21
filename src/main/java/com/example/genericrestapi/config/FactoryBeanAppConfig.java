package com.example.genericrestapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.genericrestapi.factory.GenericFactory;

@Configuration
public class FactoryBeanAppConfig {
 
    @Bean(name = "Diagnostics")
    public GenericFactory diagnosticsFactory() {
    	return new GenericFactory();
    }
    
//    @Bean(name = "SRLDiagnostics")
//    public SRLDiagnostics srlDiagnostics() {
//    	SRLDiagnostics srlDiagnostics = new SRLDiagnostics();
//        return srlDiagnostics;
//    }
 
}
