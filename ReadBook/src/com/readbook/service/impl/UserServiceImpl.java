package com.readbook.service.impl;

import com.readbook.dao.UserDao;
import com.readbook.dao.impl.UserDaoImpl;
import com.readbook.entity.User;
import com.readbook.service.UserService;

/**
 * ”√ªßService
 * @author ’≈√Ù
 */
public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public User login(String username, String password) throws Exception {
		return userDao.login(username, password);
	}

}
