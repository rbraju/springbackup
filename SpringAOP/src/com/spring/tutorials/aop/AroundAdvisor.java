package com.spring.tutorials.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundAdvisor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		Object o = null;
		System.out.println("^^^ AroundAdvice -- before");
		o = mi.proceed();
		System.out.println("^^^ AroundAdvice -- after");
		return o;
	}

}
