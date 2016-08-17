package com.study.jfinal.controller;

import com.jfinal.core.Controller;

/**
 * 
 * @author impler
 *
 */
public class HelloController extends Controller{

	/**
	 * index Action
	 */
	public void index(){
		super.renderText("Hello World");
	}
}
