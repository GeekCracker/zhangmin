package com.readbook.service;

import com.readbook.entity.User;

public interface UserService {

	/**
	 * �û���¼����
	 * @param username �����û���
	 * @param password �����û�����
	 * @return �����û���Ϣ
	 */
	User login(String username,String password) throws Exception;
}
