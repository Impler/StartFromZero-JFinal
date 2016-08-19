package com.study.jfinal.util;

import javax.sql.DataSource;

import com.jfinal.kit.PathKit;
import com.jfinal.kit.Prop;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.jfinal.plugin.c3p0.C3p0Plugin;

/**
 * 自动生成model和domain
 * @author impler
 *
 */
public class ModelGenerator {

	public static void main(String[] args) {
		// base model 所使用的包名，项目逻辑路径
		String baseModelPkg = "com.study.jfinal.activerecord.model";
		// base model 文件保存路径，物理路径
		String baseModelDir = PathKit.getWebRootPath()
				+ "/src/main/java/com/study/jfinal/activerecord/model";
		
		// model 所使用的包名，项目逻辑路径
		String modelPkg = "com.study.jfinal.activerecord.domain";
		// model 文件保存路径，物理路径
		String modelDir = baseModelDir + "/../domain";
		
		Generator gernerator = new Generator(getDataSource(), baseModelPkg,
				baseModelDir, modelPkg, modelDir);
		
		// 生成对象的时候忽略表名前缀
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
