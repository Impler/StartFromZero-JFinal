package com.study.jfinal.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.study.jfinal.validator.MyValidator;

public class ValidatorController extends Controller {

	public void index(){
		// 进入页面时，在session中生成随机字符串
		super.createToken("REFRESHTOKEN");
		System.out.println("************" + super.getAttr("token"));
		super.render("index.jsp");
	}
	
	// 添加验证拦截器
	@Before(MyValidator.class)
	public void test(){
		// 可以在Validator中验证，防止重复提交。 如果提交值和session值一致，则
		if(!super.validateToken("REFRESHTOKEN")){
			super.renderText("不能重复提交");
		}else{
			super.render("success.jsp");
		}
	}
	
}
