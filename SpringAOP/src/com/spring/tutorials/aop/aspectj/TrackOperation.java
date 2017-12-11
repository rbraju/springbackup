package com.spring.tutorials.aop.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Aspect class
 */
@Aspect
public class TrackOperation {

	@Pointcut("execution(* Operation.*(..))")
	public void pointcut1() {

	}

	@Before("k()") // Applying point cut on before advice
	public void beforeAdvise(JoinPoint jp) {
		System.out.println("Additional info in beforeAdvise()");
	}
}
