package com.study.jfinal.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * 全局拦截器，需要在JFinalConfig中注册
 * @author impler
 *
 */
public abstract class GlobalInterceptor implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		System.out.println();
		// router中注册的路径，只针对控制层对象
		String actionKey = "";
		if(inv.isActionInvocation()){
			actionKey = "【" + inv.getActionKey() + "】";
		}
		// 目标对象
		Object target = inv.getTarget();
		String methodName = inv.getMethodName();
		System.out.println(super.getClass().getSimpleName() + ":" + actionKey + "****<<before>>****" + target + ", >>>>" + methodName + "()");
		inv.invoke();
		System.out.println(super.getClass().getSimpleName() + ":" + actionKey + "****<<after >>****" + target + ", >>>>" + methodName + "()");
	}
}
