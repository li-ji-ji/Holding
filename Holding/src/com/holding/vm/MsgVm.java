package com.holding.vm;

import com.holding.po.User;

public class MsgVm {
	private Integer code;
	private String Msg;
	private User user;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return Msg;
	}
	public void setMsg(String msg) {
		Msg = msg;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "MsgVm [code=" + code + ", Msg=" + Msg + ", user=" + user + "]";
	}
	
}
