package com.readbook.dao.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.readbook.dao.RoleDao;
import com.readbook.entity.Role;
import com.readbook.utils.BeanUtil;
import com.readbook.utils.JDBCUtils;

public class RoleDaoImpl implements RoleDao{

	@Override
	public void save(Role role) {
		String sql = "insert into t_role(role_name,enable) values (?,?)";
		long id = JDBCUtils.doSave(sql,role.getRoleName(),role.getEnable());
		role.setId(id);
	}

	@Override
	public void deleteById(Long id) {
		String sql = "delete from t_role where id = ?";
		JDBCUtils.doUpdate(sql, id);
	}

	@Override
	public void updateById(Role role) {
		StringBuilder sql = new StringBuilder("update t_role set id = ? ");
		List<Object> args = new LinkedList<Object>();
		args.add(role.getId());
		String roleName = role.getRoleName();
		if(roleName != null && !"".equals(roleName)){
			sql.append(",role_name = ?");
			args.add(roleName);
		}
		Boolean enable = role.getEnable();
		if(enable != null){
			sql.append(",enable = ?");
			args.add(enable);
		}
		sql.append(" where id = ?");
		args.add(role.getId());
		JDBCUtils.doUpdate(sql.toString(), args.toArray());
	}

	@Override
	public Long selectTotal(String sql, Object... objs) {
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
	public List<Role> selectAll() {
		String sql = "select id,role_name as roleName from t_role";
		List<Map<String,Object>> results = JDBCUtils.doQuery(sql);
		return BeanUtil.populate(results, Role.class);
	}

	@Override
	public List<Role> selectPageData(String sql, Object... objs) {
		List<Map<String,Object>> results = JDBCUtils.doQuery(sql, objs);
		return BeanUtil.populate(results, Role.class);
	}
}
