package com.study.jfinal.test.activerecord;

import org.junit.Test;

import com.study.jfinal.activerecord.domain.User;

public class TestActiveRecord extends AbsBaseTest {

	@Test
	public void testSave() {
		User u = new User();
		u.set("username", "saveUser").set("email", "1211212@qq.com")
				.set("mobileNum", "19881888188").save();
		System.out.println("testSave: " + u);
	}
	

}