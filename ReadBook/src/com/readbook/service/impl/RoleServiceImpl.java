package com.readbook.service.impl;

import java.util.LinkedList;
import java.util.List;

import com.readbook.dao.RoleDao;
import com.readbook.dao.RolePermissionDao;
import com.readbook.dao.impl.RoleDaoImpl;
import com.readbook.dao.impl.RolePermissionDaoImpl;
import com.readbook.entity.Role;
import com.readbook.entity.RolePermission;
import com.readbook.page.RolePage;
import com.readbook.response.ResponseResult;
import com.readbook.service.RoleService;

public class RoleServiceImpl implements RoleService{

	private RoleDao roleDao = new RoleDaoImpl();
	
	private RolePermissionDao rolePermissionDao = new RolePermissionDaoImpl();
	
	@Override
	public void save(Role role) {
		roleDao.save(role);
		//添加角色对应权限
		String permissionIds = role.getPermissionIds();
		if(permissionIds != null && !"".equals(permissionIds)){
			String [] pIds = permissionIds.split(",");
			List<RolePermission> rolePermissions = new LinkedList<RolePermission>();
			for(String pId : pIds){
				RolePermission rolePermission = new RolePermission();
				rolePermission.setRoleId(role.getId());
				rolePermission.setPermissionId(Long.valueOf(pId));
				rolePermissions.add(rolePermission);
			}
			rolePermissionDao.saveBatch(rolePermissions);
		}
	}

	@Override
	public void deleteById(Long id) {
		roleDao.deleteById(id);
		rolePermissionDao.deleteByRoleId(id);
	}

	@Override
	public void updateById(Role role) {
		roleDao.updateById(role);
		rolePermissionDao.deleteByRoleId(role.getId());
		//添加角色对应权限
		String permissionIds = role.getPermissionIds();
		if(permissionIds != null && !"".equals(permissionIds)){
			String [] pIds = permissionIds.split(",");
			List<RolePermission> rolePermissions = new LinkedList<RolePermission>();
			for(String pId : pIds){
				RolePermission rolePermission = new RolePermission();
				rolePermission.setRoleId(role.getId());
				rolePermission.setPermissionId(Long.valueOf(pId));
				rolePermissions.add(rolePermission);
			}
			rolePermissionDao.saveBatch(rolePermissions);
		}
	}

	@Override
	public ResponseResult queryPageData(RolePage page) {
		//声明查询记录总数的sql
		String totalSQL = "select count(*) as count from v_role ";
		//声明查询记录的sql
		String selectSQL = "select "+selectFields()+" from v_role ";
		//组装where条件
		StringBuilder whereSQL = new StringBuilder("where 1=1 ");
		List<Object> args = new LinkedList<Object>();
		String roleName = page.getRoleName();
		if(roleName != null && !"".equals(roleName.trim())){
			whereSQL.append(" and role_name like ? ");
			args.add(roleName + "%");
		}
		//组装limit
		String limit = " limit " + page.getStartIndex() + "," + page.getLimit();
		//查询数据总数
		Long total = roleDao.selectTotal(totalSQL + whereSQL.toString() ,args.toArray());
		//查询数据记录
		List<Role> datas = roleDao.selectPageData(selectSQL + whereSQL.toString() + limit, args.toArray());
		return ResponseResult.ok(datas, total);
	}
	
	private String selectFields(){
		return "id,role_name as roleName,enable,permission_ids as permissionIds";
	}
}
