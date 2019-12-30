package com.readbook.dao;

import java.lang.reflect.InvocationTargetException;

import com.readbook.entity.User;

public interface UserDao {

	
	/**
	 * ��¼����
	 * @param username �����û���
	 * @param password ��������
	 * @return �����û���Ϣ
	 */
	public User login(String username,String password)  throws NullPointerException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
