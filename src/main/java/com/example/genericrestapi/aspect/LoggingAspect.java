package com.example.genericrestapi.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingAspect {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Around(value = "execution(* com.example.genericrestapi.*.*.*(..))" + "&& !within(com.example.genericrestapi.config.*)"+ "&& !within(com.example.genericrestapi.factory.*)")
	public Object logging(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		ObjectMapper objectMapper = new ObjectMapper();
		String methodName = proceedingJoinPoint.getSignature().getName();
		String className = proceedingJoinPoint.getTarget().getClass().toString();
		Object[] arguments = proceedingJoinPoint.getArgs();
		log.info("Call from " + className + ":" + methodName + "()" + "Arguments :"
				+ objectMapper.writeValueAsString(arguments));
		Object response = proceedingJoinPoint.proceed();
		log.info("Response from " + className + ":" + methodName + "()" + "Response :"
				+ objectMapper.writeValueAsString(response));

		return response;
	}
}
