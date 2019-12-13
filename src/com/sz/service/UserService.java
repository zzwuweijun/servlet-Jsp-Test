package com.sz.service;

import com.sz.pojo.User;

public interface UserService {
	/**
	 * 用户校验登录	
	 * @param uname 用户名
	 * @param pwd 用户密码
	 * @return 返回查询到的用户信息
	 */
	User checkUserLoginService(String uname, String pwd);
}
