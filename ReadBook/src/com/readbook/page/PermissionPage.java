package com.readbook.page;

import com.readbook.entity.Permission;

public class PermissionPage extends Page<Permission>{
	
	/**Ȩ������*/
	private String permissionName;
	
	/**����Ȩ��ID*/
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
