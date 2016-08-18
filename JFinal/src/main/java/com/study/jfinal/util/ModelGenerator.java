package com.study.jfinal.util;

import javax.sql.DataSource;

import com.jfinal.kit.PathKit;
import com.jfinal.kit.Prop;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.jfinal.plugin.c3p0.C3p0Plugin;

public class ModelGenerator {

	public static void main(String[] args) {
		// base model 所使用的包名
		String baseModelPkg = "com.study.jfinal.model";
		// base model 文件保存路径
		String baseModelDir = PathKit.getWebRootPath()
				+ "/src/main/java/com/study/jfinal/model";
		// model 所使用的包名
		String modelPkg = "com.study.jfinal.domain";
		// model 文件保存路径
		String modelDir = baseModelDir + "/../domain";
		Generator gernerator = new Generator(getDataSource(), baseModelPkg,
				baseModelDir, modelPkg, modelDir);
		gernerator.setRemovedTableNamePrefixes(new String[]{"t_"});
		
		gernerator.generate();

	}
	
	
	public static DataSource getDataSource() {
		
		Prop pro = new Prop("db.properties");
		C3p0Plugin cp = new C3p0Plugin(pro.get("jdbc.url"), 
				pro.get("jdbc.username"),
				pro.get("jdbc.password"));
		
		cp.start();
		
		return cp.getDataSource();
	}

}
