package com.study.jfinal.controller;

import java.util.Enumeration;
import java.util.Map;

import com.jfinal.core.Controller;
import com.study.jfinal.domain.Book;

/**
 * Action Controller
 * @author impler
 *
 */
public class ActionController extends Controller {
	
	/**
	 * index action
	 */
	public void index(){
		super.renderText("index Action");
	}

	/**
	 * other action
	 */
	public void other(){
		super.renderText("Other Action");
	}
	
	/**
	 * param action
	 */
	public void param(){
		// reqeust.getParameter()
		String param1 = super.getPara("param1");
		String param2 = super.getPara("param2");
		int param3 = super.getParaToInt("param3");
		
		// urlPara中的参数
		String param = super.getPara();
		String para0 = super.getPara(0);
		String para1 = super.getPara(2);
		
		// request.getParameterMap()
		Map<String, String[]> paraMap = super.getParaMap();
		// request.getParameterMap()
		Enumeration<String> paraNames = super.getParaNames();
		
		StringBuilder sb = new StringBuilder();
		sb.append("param1=").append(param1).append("   ")
			.append("param2=").append(param2).append("   ")
			.append("param3=").append(param3).append("   ")
			.append("urlPara[ getPara()=").append(param).append("   ")
			.append("getPara(0)=").append(para0).append("   ")
			.append("getPara(1)=").append(para1).append("]   ")
			.append("getParaMap()=").append(paraMap).append("   ")
			.append("getParaNames()=").append(paraNames);
		
		super.renderText(sb.toString());
	}
	
	/**
	 * model action
	 */
	public void model(){
		
		Book book1 = super.getModel(Book.class);
		Book book2 = super.getBean(Book.class, "book");
		
		StringBuffer sb = new StringBuffer();
		sb.append("getModel=").append(book1).append("===")
			.append("getBean=").append(book2);
		
		super.renderText(sb.toString());
	}
}
