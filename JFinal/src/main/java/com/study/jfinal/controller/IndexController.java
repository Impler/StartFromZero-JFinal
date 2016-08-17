package com.study.jfinal.controller;

import com.jfinal.core.Controller;

/**
 * 充当welcome file
 * @author index
 *
 */
public class IndexController extends Controller {

	public void index(){
		super.render("index.jsp");
	}
}
