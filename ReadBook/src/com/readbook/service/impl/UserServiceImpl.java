package com.readbook.service.impl;

import java.util.LinkedList;
import java.util.List;

import com.readbook.dao.UserDao;
import com.readbook.dao.impl.UserDaoImpl;
import com.readbook.entity.User;
import com.readbook.page.UserPage;
import com.readbook.response.ResponseResult;
import com.readbook.service.UserService;

/**
 * 用户Service
 * @author 张敏
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
	public void updateById(User user) {
		userDao.updateById(user);
	}

	@Override
	public ResponseResult queryPageData(UserPage page) {		
		//声明查询记录总数的sql
		String totalSQL = "select count(*) as count from v_user ";
		//声明查询记录的sql
		String selectSQL = "select "+selectFields()+" from v_user ";
		
		//组装where条件
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
		//组装limit
		String limit = " limit " + page.getStartIndex() + "," + page.getLimit();
		//查询数据总数
		Long total = userDao.selectTotal(totalSQL + whereSQL.toString(),args.toArray());
		//查询数据记录
		List<User> datas = userDao.selectPageData(selectSQL + whereSQL.toString() + limit, args.toArray());
		return ResponseResult.ok(datas,total);
	}

	private String selectFields(){
		return "id,username,password,phone,role_id as roleId,role_name as roleName";
	}
}
