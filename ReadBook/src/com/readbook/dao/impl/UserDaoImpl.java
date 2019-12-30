package com.readbook.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import com.readbook.dao.UserDao;
import com.readbook.entity.User;
import com.readbook.utils.BeanUtil;
import com.readbook.utils.JDBCUtils;

public class UserDaoImpl implements UserDao{

	
	
	@Override
	public User login(String username, String password) throws NullPointerException, IllegalAccessException, InvocationTargetException, InstantiationException {
		String sql = "select * from t_user where username = ? and password = ?";
		List<Map<String,Object>> results = JDBCUtils.doQuery(sql, username,password);
		List<User> users = BeanUtil.populate(results, User.class);
		if(users != null && users.size() == 1){
			return users.get(0);
		}
		return null;
	}

}
