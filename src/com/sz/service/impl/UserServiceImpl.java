package com.sz.service.impl;

import com.sz.dao.UserDao;
import com.sz.dao.impl.UserDaoImpl;
import com.sz.pojo.User;
import com.sz.service.UserService;

public class UserServiceImpl implements UserService {
	// 声明Dao层对象
	UserDao userDao = new UserDaoImpl();

	// 用户登录
	@Override
	public User checkUserLoginService(String uname, String pwd) {
		return userDao.checkUserLoginDao(uname, pwd);
	}

}
