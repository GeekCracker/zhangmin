package com.readbook.service;

import com.readbook.entity.User;
import com.readbook.page.UserPage;

public interface UserService {

	/**
	 * �û���¼����
	 * @param username �����û���
	 * @param password �����û�����
	 * @return �����û���Ϣ
	 */
	User login(String username,String password);
	
	/**
	 * ����û�
	 * @param user ������Ҫ��ӵ��û�
	 */
	void save(User user);
	
	/**
	 * ����IDɾ���û�
	 * @param id �����û�ID
	 */
	void deleteById(Long id);
	
	/**
	 * ����ID�޸��û���Ϣ
	 * @param user ������Ҫ�޸ĵ��û���Ϣ
	 */
	void updateById(User user);

	
	/**
	 * ��ȡ��ҳ����
	 * @param page �����ҳ����
	 * @return ���ط�ҳ����
	 */
	UserPage queryPageData(UserPage page);
}
