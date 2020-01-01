package com.readbook.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.readbook.dao.PermissionDao;
import com.readbook.dao.impl.PermissionDaoImpl;
import com.readbook.entity.Permission;
import com.readbook.page.PermissionPage;
import com.readbook.response.ResponseResult;
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
	public ResponseResult queryPageData(PermissionPage page) {
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
		//组装limit
		String limit = " limit " + page.getStartIndex() + "," + page.getLimit();
		//查询数据总数
		Long total = permissionDao.selectTotal(totalSQL + whereSQL.toString() ,args.toArray());
		//查询数据记录
		List<Permission> datas = permissionDao.selectPageData(selectSQL + whereSQL.toString() + limit, args.toArray());
		return ResponseResult.ok(datas, total);
	}
	
	
	@Override
	public List<Permission> permissionTree() {
		List<Permission> permissions = permissionDao.selectAll();
		if(permissions != null){
			List<Permission> topPermission = topPermission(permissions);
			deep(topPermission,permissions);
			return topPermission;
		}
		return new LinkedList<>();
	}

	private List<Permission> topPermission(List<Permission> permissions){
		return permissions.stream().filter(item->item.getParentId() == null || item.getParentId() == 0).collect(Collectors.toList());
	}
	
	private void deep(List<Permission> permissionTree,List<Permission> permissions){
		for(Permission permission : permissionTree){
			List<Permission> children = permissions.stream().filter(item-> permission.getId().equals(item.getParentId())).collect(Collectors.toList());
			if(!children.isEmpty()){
				deep(children,permissions);
			}
			permission.setChildren(children);
		}
	}
	
	private String selectFields(){
		return "id as id,permission_name as permissionName,parent_id as parentId";
	}
}
