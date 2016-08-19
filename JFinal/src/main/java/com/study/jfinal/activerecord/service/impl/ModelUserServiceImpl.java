package com.study.jfinal.activerecord.service.impl;

import com.jfinal.plugin.activerecord.Page;
import com.study.jfinal.activerecord.bean.Result;
import com.study.jfinal.activerecord.domain.User;
import com.study.jfinal.activerecord.service.UserService;

public class ModelUserServiceImpl implements UserService {

	@Override
	public Result addUser(User user) {
		boolean result = user.save();
		String msg = null;
		if(result){
			msg = "添加成功";
		}else{
			msg = "添加失败";
		}
		return Result.newResult(result, msg);
	}

	@Override
	public User queryUserById(int id) {
		return User.dao.findById(id);
	}

	@Override
	public Result updateUser(User user) {
		boolean result = user.update();
		String msg = null;
		if(result){
			msg = "修改成功";
		}else{
			msg = "修改失败";
		}
		return Result.newResult(result, msg);
	}

	@Override
	public Result deleteUser(int id) {
		boolean result = User.dao.deleteById(id);
		String msg = null;
		if(result){
			msg = "删除成功";
		}else{
			msg = "删除失败";
		}
		return Result.newResult(result, msg);
	}

	@Override
	public Page<User> queryAllUsers() {
		return User.dao.paginate(1, 100, "select *", "from t_user");
	}

}
