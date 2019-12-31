package com.readbook.page;

import com.readbook.entity.Permission;

public class PermissionPage extends Page<Permission>{
	
	/**权限名称*/
	private String permissionName;
	
	/**父级权限ID*/
	private Long parentId;

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
}
