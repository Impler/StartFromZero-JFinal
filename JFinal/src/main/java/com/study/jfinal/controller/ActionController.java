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
		String param_1 = super.getPara("param_1");
		String param2 = super.getPara("param2");
		int param3 = super.getParaToInt("param3");
		
		// 获取urlPara中的参数，如果形如/a/b?c=c1/d-e-f形式的请求，urlPara将无法获取
		String param = super.getPara();
		String para0 = super.getPara(0);
		String para1 = super.getPara(1);
		
		// request.getParameterMap()
		Map<String, String[]> paraMap = super.getParaMap();
		// request.getParameterMap()
		Enumeration<String> paraNames = super.getParaNames();
		
		StringBuilder sb = new StringBuilder();
		sb.append("param1=").append(param1).append("   ")
			.append("param_1=").append(param_1).append("   ")
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
	 * bean action 
	 * TODO model
	 */
	public void bean(){
		// 表单项name为【Book类首字母小写.属性名】形式
		Book book1 = super.getBean(Book.class);
		// 表单项name为【自定义前缀.属性名】，如bk.name
		Book book2 = super.getBean(Book.class, "bk");
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("getBean book:").append(book1).append("   ")
			.append("getBean bk:").append(book2);
		
		super.renderText(sb.toString());
	}
	
	/**
	 * setAttr action
	 */
	public void setAttr(){
		String attr = super.getPara("attr");
		// 调用HttpServletRequest.setAttribute(String, Object)
		super.setAttr("attr", attr);
		super.render("attribute.jsp");
	}
	
	/**
	 * session action
	 */
	public void session(){
		String attr = super.getPara("attr");
		// 调用 session。setAttribute(String, Object)
		super.setSessionAttr("attr", attr);
		super.render("attribute.jsp");
	}
}
