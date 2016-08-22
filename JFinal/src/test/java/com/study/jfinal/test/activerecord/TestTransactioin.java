package com.study.jfinal.test.activerecord;

import java.sql.SQLException;
import java.util.Random;
import java.util.regex.Pattern;

import org.junit.Test;

import com.jfinal.aop.Duang;
import com.jfinal.aop.InterceptorManager;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.IAtom;
import com.jfinal.plugin.activerecord.tx.TxByMethodRegex;
import com.study.jfinal.activerecord.domain.User;

public class TestTransactioin extends AbsBaseTest {

	
	@Test
	public void testCodeTransaction(){
		Db.tx(new IAtom(){

			@Override
			// 方法执行异常或返回false，事务回滚
			public boolean run() throws SQLException {
				return transactionTest("testCodeTransaction");
			}
			
		});
	}
	
	@Test
	public void testAnnoTransaction(){
		FooService service = Duang.duang(FooService.class);
		service.addUser();
	}
	
	@Test
	public void testGlobalTranctionInterceptor1(){
		// web项目在JFinalConfig中配置，这里从代码中抠出来这样注册，测试用
		// 这里拦截方法名中包含save、update的方法
		InterceptorManager.me().addGlobalServiceInterceptor(new TxByMethodRegex("(.*save.*|.*update.*)"));
		FooService service = Duang.duang(FooService.class);
		// 不会受事务管理
		service.add();
	}
	
	@Test
	public void testGlobalTranctionInterceptor2(){
		// web项目在JFinalConfig中配置，这里从代码中抠出来这样注册，测试用
		// 这里拦截方法名中包含save、update的方法
		// *************************************************
		// 但是TxByMethodRegex也会拦截符合要求的非dao层（非jdbc操作）的方法
		// *************************************************
		InterceptorManager.me().addGlobalServiceInterceptor(new TxByMethodRegex("(.*save.*|.*update.*)"));
		FooService service = Duang.duang(FooService.class);
		// 受事务管理
		service.saveUser();
	}
	
	
	public static boolean transactionTest(String keyworkd){
		// 肯定会执行的数据库操作，便于比较有没有回滚
		new User().set("id", -121).set("username", keyworkd + "txUserName121").set("email", "txEmail121").save();
		int code = new Random().nextInt(10);
		boolean result = true;
		User user = null;
		if(code % 2 == 0){
			user = new User();
			user.set("id", -123).set("username", keyworkd + "txUserName123").set("email", "txEmail123");
			result = user.save();
		}
		if(!result){
			System.out.println("testCodeTransaction save 不成功");
			return false;
		}
		// id为-123的可能不存在，导致更新不成功
		result = new User().set("id", -123).set("username", keyworkd + "123").update();
		if(!result){
			System.out.println("testCodeTransaction update 不成功");
			return false;
		}
		
		if(new Random().nextInt(10) % 2 == 0){
			// 触发异常，引起事务回滚
			result = new User().set("a", "aaa").save();
		}
		
		// 最后为了不影响下次操作，删除123
		result = Db.update("delete from t_user where id in (?,?)", -121, -123) == 2;
		if(!result){
			System.out.println("testCodeTransaction delete 不成功");
		}
		return result;
	}
	
	
	public static void main(String[] args){
		Pattern p = Pattern.compile("(.*save.*|.*update.*)");
		System.out.println(p.matcher("aaasave").matches());
		System.out.println(p.matcher("a").matches());
		System.out.println(p.matcher("saveupdate").matches());
		System.out.println(p.matcher("saupdateddd").matches());
	}
}

