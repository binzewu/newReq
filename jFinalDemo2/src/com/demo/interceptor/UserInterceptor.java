package com.demo.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

public class UserInterceptor implements Interceptor{

	public void intercept(ActionInvocation ai) {
		System.out.println("��ʼ����user���...");
		ai.invoke();
		System.out.println("���user����...");
	}

}
