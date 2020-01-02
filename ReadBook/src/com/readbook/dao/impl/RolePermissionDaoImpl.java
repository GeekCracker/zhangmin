package com.readbook.dao.impl;

import java.util.LinkedList;
import java.util.List;

import com.readbook.dao.RolePermissionDao;
import com.readbook.entity.RolePermission;
import com.readbook.utils.JDBCUtils;

public class RolePermissionDaoImpl implements RolePermissionDao{

	@Override
	public int save(RolePermission rolePermission) {
		StringBuilder sql = new StringBuilder("insert into t_role_permission(role_id,permission_id) values (?,?)");
		return JDBCUtils.doUpdate(sql.toString(), rolePermission.getRoleId(),rolePermission.getPermissionId());
	}

	@Override
	public int saveBatch(List<RolePermission> list) {
		StringBuilder sql = new StringBuilder("insert into t_role_permission(role_id,permission_id) values ");
		if(list != null && !list.isEmpty()){
			List<Object> args = new LinkedList<Object>();
			for(RolePermission rolePermission : list){
				sql.append("(?,?),");
				args.add(rolePermission.getRoleId());
				args.add(rolePermission.getPermissionId());
			}
			sql.deleteCharAt(sql.length() - 1);
			return JDBCUtils.doUpdate(sql.toString(), args.toArray());
		}
		return 0;
	}

	@Override
	public int deleteByRoleId(Long roleId) {
		StringBuilder sql = new StringBuilder("delete from t_role_permission where role_id = ?");
		return JDBCUtils.doUpdate(sql.toString(),roleId);
	}
}
