package com.readbook.dao.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.readbook.dao.PermissionDao;
import com.readbook.entity.Permission;
import com.readbook.utils.BeanUtil;
import com.readbook.utils.JDBCUtils;

public class PermissionDaoImpl implements PermissionDao{

	@Override
	public void save(Permission permission) {
		String sql = "insert into t_permission(permission_name,permission_bit,url,parent_id) value (?,?,?,?)";
		long id = JDBCUtils.doSave(sql,permission.getPermissionName(),permission.getPermissionBit(),permission.getUrl(),permission.getParentId());
		permission.setId(id);
	}

	@Override
	public void deleteById(Long id) {
		String sql = "delete from t_permission where id = ?";
		JDBCUtils.doUpdate(sql, id);
	}

	@Override
	public void updateById(Permission permission) {
		String sql = "update t_permission set id = ? ";
		List<Object> args = new LinkedList<Object>();
		args.add(permission.getId());
		String permissionName = permission.getPermissionName();
		if(permissionName != null && !"".equals(permissionName)){
			sql += ",permission_name = ?";
			args.add(permissionName);
		}
		String permissionBit = permission.getPermissionBit();
		if(permissionBit != null && !"".equals(permissionBit)){
			sql += ",permission_bit = ?";
			args.add(permissionBit);
		}
		String url = permission.getUrl();
		if(url != null && !"".equals(url)){
			sql += ",url = ?";
			args.add(url);
		}
		Long parentId = permission.getParentId();
		if(parentId != null && parentId > 0){
			sql += ",parent_id = ?";
		}
		sql += " where id = ?";
		args.add(permission.getId());
		JDBCUtils.doUpdate(sql, args.toArray());
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
	public List<Permission> selectPageData(String sql, Object... objs) {
		List<Map<String,Object>> results = JDBCUtils.doQuery(sql, objs);
		return BeanUtil.populate(results, Permission.class);
	}

	@Override
	public List<Permission> selectAll() {
		String sql = "select id as id,permission_name as permissionName,permission_bit as permissionBit,url as url,parent_id as parentId from t_permission";	
		List<Map<String,Object>> results = JDBCUtils.doQuery(sql);
		return BeanUtil.populate(results, Permission.class);
	}
}
