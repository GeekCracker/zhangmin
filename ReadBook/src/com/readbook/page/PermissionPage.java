package com.readbook.page;

import com.readbook.entity.Permission;

public class PermissionPage extends Page<Permission>{
	
	/**权限名称*/
	private String permissionName;
	
	/**权限位*/
	private String permissionBit;
	
	/**父级权限ID*/
	private Long parentId;

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	
	public String getPermissionBit() {
		return permissionBit;
	}

	public void setPermissionBit(String permissionBit) {
		this.permissionBit = permissionBit;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
}
