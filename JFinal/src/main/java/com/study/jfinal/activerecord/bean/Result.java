package com.study.jfinal.activerecord.bean;

public class Result {

	// 结果提示信息
	private String msg;
	// 结果状态
	private boolean isSuccess;

	public Result() {
		super();
	}

	public Result(boolean isSuccess, String msg) {
		super();
		this.isSuccess = isSuccess;
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	public static Result newResult(boolean isSuccess, String msg){
		return new Result(isSuccess, msg);
	}

}


