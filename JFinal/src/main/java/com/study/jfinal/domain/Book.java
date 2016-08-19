package com.study.jfinal.domain;

/**
 * 普通的POJO，对比com.study.jfinal.activerecord.domain.User看下
 * @author impler
 *
 */
public class Book {

	// 书名
	private String name;
	// 作者
	private String author;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "Book [name=" + name + ", author=" + author + "]";
	}
	
}
