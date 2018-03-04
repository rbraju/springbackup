package com.spring.tutorials.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

// Comment from branch 2
public class BeforeAdvisor implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("*** Additional concern before actual logic");
		System.out.println("*** Method info: " + method.getName() + " --> " + method.getModifiers());
		System.out.println("*** Arguments info: ");
		for (Object o : args) {
			System.out.println("\t" + o);
		}
		System.out.println("*** Target object: " + target.toString());
	}

}
