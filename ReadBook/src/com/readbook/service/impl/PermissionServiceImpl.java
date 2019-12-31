package com.readbook.service.impl;

import java.util.LinkedList;
import java.util.List;

import com.readbook.dao.PermissionDao;
import com.readbook.dao.impl.PermissionDaoImpl;
import com.readbook.entity.Permission;
import com.readbook.page.PermissionPage;
import com.readbook.service.PermissionService;

public class PermissionServiceImpl implements PermissionService{

	private PermissionDao permissionDao = new PermissionDaoImpl();
	
	@Override
	public void save(Permission permission) {
		permissionDao.save(permission);
	}

	@Override
	public void deleteById(Long id) {
		permissionDao.deleteById(id);
	}

	@Override
	public void updateById(Permission permission) {
		permissionDao.updateById(permission);
	}

	@Override
	public PermissionPage queryPageData(PermissionPage page) {
		//声明查询记录总数的sql
		String totalSQL = "select count(*) as count from t_permission ";
		//声明查询记录的sql
		String selectSQL = "select "+selectFields()+" from t_permission ";
		//组装where条件
		StringBuilder whereSQL = new StringBuilder("where 1=1 ");
		List<Object> args = new LinkedList<Object>();
		String permissionName = page.getPermissionName();
		if(permissionName != null && !"".equals(permissionName.trim())){
			whereSQL.append(" and permission_name = ? ");
			args.add(permissionName);
		}
		Long parentId = page.getParentId();
		if(parentId != null && parentId > 0){
			whereSQL.append(" and parent_id = ? ");
			args.add(parentId);
		}
		//查询数据总数
		Long total = permissionDao.selectTotal(totalSQL,args.toArray());
		//查询数据记录
		List<Permission> datas = permissionDao.selectPageData(selectSQL, args.toArray());
		page.setTotal(total);
		page.setDatas(datas);
		return page;
	}
	
	private String selectFields(){
		return "id,permission_name,parent_id";
	}
}
