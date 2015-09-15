package com.rick.guava_example.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.google.common.reflect.Reflection;

public class TransactionProxy implements InvocationHandler {
	
	private Insert target;
	
	public Insert bind(Insert obj) {
		this.target = obj;
		return Reflection.newProxy(Insert.class, this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("Start transaction!");
		Object o = method.invoke(target, args);
		System.out.println("Submit transaction!");
		return o;
	}

}
