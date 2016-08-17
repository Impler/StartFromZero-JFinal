package com.study.jfinal.router;

import com.jfinal.config.Routes;
import com.study.jfinal.controller.IndexController;

/**
 * 自定义Router
 * @author impler
 *
 */
public class IndexRouter extends Routes {

	@Override
	public void config() {
		super.add("/", IndexController.class);
	}

}
