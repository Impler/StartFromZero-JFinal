package com.study.jfinal.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
/**
 * 该拦截器本身并没有什么特别之处，类名只做含义上的区分
 * @author impler
 *
 */
public abstract class MethodInterceptor implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		// router中注册的路径，只针对控制层对象
		String actionKey = "";
		if(inv.isActionInvocation()){
			actionKey = "【" + inv.getActionKey() + "】";
		}
		// 目标对象
		Object target = inv.getTarget();
		String methodName = inv.getMethodName();
		System.out.println("---->---->" + super.getClass().getSimpleName() + actionKey + "****<<before>>****" + target + ", >>>>" + methodName + "()");
		inv.invoke();
		System.out.println("---->---->" + super.getClass().getSimpleName() + actionKey + "****<<after >>****" + target + ", >>>>" + methodName + "()");
	}

}
