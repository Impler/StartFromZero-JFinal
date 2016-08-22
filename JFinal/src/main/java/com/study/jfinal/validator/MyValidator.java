package com.study.jfinal.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * 自定义验证器
 * 验证器也是基于拦截器来实现
 * @author impler
 *
 */
public class MyValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		// false: "0"/"false", true: "1"/"true"
		super.validateBoolean("isMarried", "[isMarried]", "【isMarried】格式不对");
		// 必填项
		super.validateRequired("name", "[name]", "【name】为必填项");
		
	}

	@Override
	protected void handleError(Controller c) {
		c.renderText((String) c.getAttr("[isMarried]") + " , " + c.getAttrForStr("[name]"));
	}

}
