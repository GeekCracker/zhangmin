package com.readbook.dao;

import java.util.List;
import com.readbook.entity.User;

public interface UserDao {

	
	/**
	 * ��¼����
	 * @param username �����û���
	 * @param password ��������
	 * @return �����û���Ϣ
	 */
	public User login(String username,String password);

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
	 * ����ID�޸��û�
	 * @param user ������Ҫ�޸ĵ��û�
	 */
	void updateById(User user);
	
	
	/**
	 * ��ѯ��������
	 * @param sql ����sql���
	 * @param objs �����ѯ����
	 * @return ������������
	 */
	Long selectTotal(String sql,Object... objs);
	
	/**
	 * ��ѯ��ҳ����
	 * @param sql ����sql���
	 * @param objs �����ѯ����
	 * @return ���ط�ҳ����
	 */
	List<User> selectPageData(String sql,Object... objs);
}
