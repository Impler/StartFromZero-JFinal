package com.study.jfinal.test.activerecord;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.tx.Tx;

public class FooService {

	public FooService() {
	}

	// 仅在抛出异常时回滚
	@Before(Tx.class)
	public void addUser() {
		TestTransactioin.transactionTest("addUser");
	}
	
	public void add(){
		TestTransactioin.transactionTest("add");
	}
	
	// 将会被全局service 事务拦截器拦截
	public void saveUser(){
		TestTransactioin.transactionTest("saveUser");
	}
}
