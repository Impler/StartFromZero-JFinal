package com.study.jfinal.configuration;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.study.jfinal.controller.ActionController;
import com.study.jfinal.controller.HelloController;
import com.study.jfinal.controller.InterceptrController;
import com.study.jfinal.interceptor.controller.GlobalControllerInterceptor;
import com.study.jfinal.interceptor.service.GlobalServiceInterceptor;
import com.study.jfinal.model.User;
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
		loadPropertyFile("db.properties");
		
		// C3P0数据库连接池插件
		C3p0Plugin cp = new C3p0Plugin(super.getProperty("jdbc.url"),
				super.getProperty("jdbc.username"),
				super.getProperty("jdbc.password"));
		me.add(cp);
		
		// ActiveRecrod支持插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
		// 表名、主键名默认id、Model Class对象
		arp.addMapping("t_user", User.class);
		me.add(arp);

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
