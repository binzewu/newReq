package com.demo.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

public class UserInterceptor implements Interceptor{

	public void intercept(ActionInvocation ai) {
		System.out.println("开始进行user添加...");
		ai.invoke();
		System.out.println("添加user结束...");
	}

}
