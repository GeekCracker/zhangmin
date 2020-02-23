package com.readbook.dao.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.readbook.dao.UserDao;
import com.readbook.entity.User;
import com.readbook.utils.BeanUtil;
import com.readbook.utils.JDBCUtils;

public class UserDaoImpl implements UserDao{

	@Override
	public User login(String username, String password){
		String sql = "select * from t_user where username = ? and password = ?";
		List<Map<String,Object>> results = JDBCUtils.doQuery(sql, username,password);
		List<User> users = BeanUtil.populate(results, User.class);
		if(users != null && users.size() == 1){
			return users.get(0);
		}
		return null;
	}

	@Override
	public void save(User user) {
		String sql = "insert into t_user(username,password,phone) value (?,?,?)";
		long id = JDBCUtils.doSave(sql, user.getUsername(),user.getPassword(),user.getPhone());
		user.setId(id);
	}

	@Override
	public void deleteById(Long id) {
		String sql = "delete from t_user where id = ?";
		JDBCUtils.doUpdate(sql, id);
	}

	@Override
	public void updateById(User user) {
		String sql = "update t_user set id = ? ";
		List<Object> args = new LinkedList<Object>();
		args.add(user.getId());
		String username = user.getUsername();
		if(username != null && !"".equals(username)){
			sql += ",username = ?";
			args.add(username);
		}
		String phone = user.getPhone();
		if(phone != null && !"".equals(phone)){
			sql += ",phone = ?";
			args.add(phone);
		}
		sql += " where id = ?";
		args.add(user.getId());
		JDBCUtils.doUpdate(sql, args.toArray());
	}

	@Override
	public Long selectTotal(String sql,Object... objs) {
		List<Map<String,Object>> results = JDBCUtils.doQuery(sql,objs);
		if(results != null && !results.isEmpty()){
			Map<String,Object> map = results.get(0);
			Object count = map.get("count");
			if(count != null){
				return (Long)map.get("count") ;
			}
		}
		return 0l;
	}

	@Override
	public List<User> selectPageData(String sql,Object... objs) {
		List<Map<String,Object>> results = JDBCUtils.doQuery(sql, objs);
		return BeanUtil.populate(results, User.class);
	}
}
