package com.study.jfinal.test.activerecord;

import org.junit.BeforeClass;

import com.jfinal.kit.Prop;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.study.jfinal.activerecord.domain.User;
/**
 * 非web环境下的测试
 * @author impler
 *
 */
public abstract class AbsBaseTest {

	@BeforeClass
	public static void beforeClass(){
		Prop pro = new Prop("db.properties");
		C3p0Plugin cp = new C3p0Plugin(pro.get("jdbc.url"), 
				pro.get("jdbc.username"),
				pro.get("jdbc.password"));
		
		ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
		arp.setShowSql(true);
		// 表名、主键名默认id、Model Class对象
		arp.addMapping("t_user", User.class);
		
		cp.start();
		arp.start();
	}
}
