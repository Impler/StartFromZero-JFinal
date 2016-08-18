package com.study.jfinal.service;

import com.jfinal.aop.Before;
import com.study.jfinal.interceptor.service.ServiceClassInterceptor;
import com.study.jfinal.interceptor.service.ServiceMethodInterceptor;

/**
 * 业务层对象
 * @author impler
 *
 */

@Before(ServiceClassInterceptor.class)
public class InterceptorService {

	@Before(ServiceMethodInterceptor.class)
	public void doBusiness(String keyword){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>InterceptorService doBusiness: " + keyword);
	}
}
