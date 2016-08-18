package com.study.jfinal.configuration;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.render.ViewType;
import com.study.jfinal.controller.ActionController;
import com.study.jfinal.controller.HelloController;
import com.study.jfinal.controller.InterceptrController;
import com.study.jfinal.interceptor.controller.GlobalControllerInterceptor;
import com.study.jfinal.interceptor.service.GlobalServiceInterceptor;
import com.study.jfinal.router.IndexRouter;

public class JFinalProjectConfig extends JFinalConfig {

	/**
	 * 配置 JFinal 常量值
	 */
	@Override
	public void configConstant(Constants me) {
		me.setDevMode(true);
		me.setViewType(ViewType.JSP);
	}

	/**
	 * 配置 JFinal 访问路由
	 */
	@Override
	public void configRoute(Routes me) {
		// 注册自定义Router
		me.add(new IndexRouter());
		// 注册路径与Controller的映射
		me.add("/hello", HelloController.class);
		// 注册路径与Controller的映射
		me.add("/action", ActionController.class, "/view/jsp/action");
		
		me.add("/interceptor", InterceptrController.class);

	}

	@Override
	public void configPlugin(Plugins me) {
		// TODO Auto-generated method stub

	}

	/**
	 * 注册全局拦截器，包括控制层全局烂机器和业务层全局拦截器
	 */
	@Override
	public void configInterceptor(Interceptors me) {
		// 注册全局控制层拦截器
		me.addGlobalActionInterceptor(new GlobalControllerInterceptor());
		// 注册全局业务层拦截器
		me.addGlobalServiceInterceptor(new GlobalServiceInterceptor());
	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub

	}

}
