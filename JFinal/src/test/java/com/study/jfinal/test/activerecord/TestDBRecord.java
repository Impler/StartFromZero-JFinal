package com.study.jfinal.test.activerecord;

import java.util.List;

import org.junit.Test;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

public class TestDBRecord extends AbsBaseTest {

	private static final String T_USER = "t_user";
	
	@Test
	public void testSave(){
		Db.save(T_USER,
				new Record().set("username", "dbSaveUser")
						.set("email", "8888@qq.com").set("mobilenum", "188888"));
	}
	
	
	@Test
	public void testFind(){
		List<Record> users = Db.find("select * from t_user");
		for(int i=0; i<users.size(); i++){
			Record rd = users.get(i);
			showRecord(rd);
		}
	}
	
	private void showRecord(Record rd){
		String[] colNames = rd.getColumnNames();
		StringBuffer sb = new StringBuffer();
		for(String name : colNames){
			sb.append(name).append(":").append(rd.get(name)).append(",");
		}
		System.out.println(sb.toString());
	}
	
}
