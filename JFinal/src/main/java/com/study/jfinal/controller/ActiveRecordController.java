package com.study.jfinal.controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.study.jfinal.activerecord.bean.Result;
import com.study.jfinal.activerecord.domain.User;
import com.study.jfinal.activerecord.service.UserService;
import com.study.jfinal.activerecord.service.impl.ModelUserServiceImpl;

public class ActiveRecordController extends Controller {

	public static final String RESULT_KEY = "result";
	public static final String V_RESULT = "result.jsp";
	
	private UserService modelService = new ModelUserServiceImpl();
	
	public void index(){
		Integer id = super.getParaToInt("id");
		if(null != id){
			User u = modelService.queryUserById(id);
			super.setAttr("bean", u);
		}
		super.render("add.jsp");
	}
	
	public void addUser(){
		User user = super.getModel(User.class);
		Result result = modelService.addUser(user);
		gotoResultPage(result);
	}
	
	
	public void queryAll(){
		Page<User> us = modelService.queryAllUsers();
		super.setAttr("page", us);
		super.render("list.jsp");
	}
	
	public void detail(){
		int id = super.getParaToInt("id");
		User u = modelService.queryUserById(id);
		super.renderJson(u.toJson());
	}
	
	public void delete(){
		int id  = super.getParaToInt("id");
		Result result = modelService.deleteUser(id);
		super.setAttr(RESULT_KEY, result);
		super.forwardAction("/user/queryAll");
	}
	
	public void update(){
		User u = super.getModel(User.class);
		Result result = modelService.updateUser(u);
		super.setAttr(RESULT_KEY, result);
		super.forwardAction("/user/queryAll");
	}
	
	
	
	
	private void gotoResultPage(Result result){
		super.setAttr(RESULT_KEY, result);
		super.render(V_RESULT);
	}
	
	
	
}
