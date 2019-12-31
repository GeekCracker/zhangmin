package com.readbook.service.impl;

import java.util.LinkedList;
import java.util.List;

import com.readbook.dao.UserDao;
import com.readbook.dao.impl.UserDaoImpl;
import com.readbook.entity.User;
import com.readbook.page.UserPage;
import com.readbook.service.UserService;

/**
 * �û�Service
 * @author ����
 */
public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public User login(String username, String password){
		return userDao.login(username, password);
	}

	@Override
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	public void deleteById(Long id) {
		userDao.deleteById(id);
	}

	@Override
	public UserPage queryPageData(UserPage page) {
		
		//������ѯ��¼������sql
		String totalSQL = "select count(*) as count from t_user ";
		//������ѯ��¼��sql
		String selectSQL = "select "+selectFields()+" from t_user ";
		
		//��װwhere����
		StringBuilder whereSQL = new StringBuilder("where 1=1 ");
		List<Object> args = new LinkedList<Object>();
		String username = page.getUsername();
		if(username != null && !"".equals(username.trim())){
			whereSQL.append(" and username = ? ");
			args.add(username);
		}
		String phone = page.getPhone();
		if(phone != null && !"".equals(phone.trim())){
			whereSQL.append(" and phone = ? ");
			args.add(phone);
		}
		//��ѯ��������
		Long total = userDao.selectTotal(totalSQL,args.toArray());
		//��ѯ���ݼ�¼
		List<User> datas = userDao.selectPageData(selectSQL, args.toArray());
		page.setTotal(total);
		page.setDatas(datas);
		return page;
	}
	
	private String selectFields(){
		return "id,username,password,phone";
	}
}