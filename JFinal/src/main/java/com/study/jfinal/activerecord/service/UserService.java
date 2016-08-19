package com.study.jfinal.activerecord.service;

import com.jfinal.plugin.activerecord.Page;
import com.study.jfinal.activerecord.bean.Result;
import com.study.jfinal.activerecord.domain.User;

public interface UserService {

	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public Result addUser(User user);
	
	/**
	 * 根据ID查询用户
	 * @param id
	 * @return
	 */
	public User queryUserById(int id);
	
	/**
	 * 更新用户
	 * @return
	 */
	public Result updateUser(User user);
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public Result deleteUser(int id);
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public Page<User> queryAllUsers();
}
