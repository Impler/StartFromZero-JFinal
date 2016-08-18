package com.study.jfinal.controller;

import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Enhancer;
import com.jfinal.core.Controller;
import com.study.jfinal.interceptor.controller.ControllerClassInterceptor;
import com.study.jfinal.interceptor.controller.ControllerMethodInterceptor;
import com.study.jfinal.interceptor.inject.InjectInterceptor;
import com.study.jfinal.service.InterceptorService;

/**
 * 用于测试JFinal Interceptor
 * @author impler
 *
 */
// 在class上添加拦截器，执行当前class内的任何方法将会被该拦截器拦截，多个间逗号分隔，按配置的先后顺序执行
@Before(ControllerClassInterceptor.class)
public class InterceptrController extends Controller {

	/**
	 * 受控于全局拦截器和类拦截器
	 */
	public void index(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>InterceptrController index");
		super.renderText("InterceptrController index：请查看控制台");
	}
	
	/**
	 * 受控于全局拦截器、类拦截器和方法拦截器
	 */
	@Before(ControllerMethodInterceptor.class)
	public void other(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>InterceptrController other");
		super.renderText("InterceptrController other：请查看控制台");
	}
	
	/**
	 * 清除自身级别上以上的拦截器，可以具体到某个拦截器，如@Clear(MyClassInteceptor.class)
	 */
	@Clear	//清除MyClassInteceptor和MyGlobalInterceptor，只受控于当前配置的MyMethodInteceptor
	@Before(ControllerMethodInterceptor.class)
	public void clear(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>InterceptrController clear");
		super.renderText("InterceptrController clear：请查看控制台");
	}
	
	@Clear
	public void service(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>InterceptrController service");
		// InterceptorService上添加了拦截器
		// 使用 enhance方法对业务层进行增强，使其具有AOP能力
		// ****************************************************************
		// ****************************************************************
		InterceptorService service = super.enhance(InterceptorService.class);
		// ****************************************************************
		// ****************************************************************
		service.doBusiness("service");
		super.renderText("InterceptrController service：请查看控制台");
	}
	
	/**
	 * test Inject 拦截器
	 */
	public void inject(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>InterceptrController inject");
		// 使用Enhancer.enhance方法，通过方法参数的方式绑定拦截器
		InterceptorService service = Enhancer.enhance(InterceptorService.class, InjectInterceptor.class);
		service.doBusiness("inject");
		super.renderText("InterceptrController inject：请查看控制台");
	}
}
