package com.readbook.page;

import com.readbook.entity.Permission;

public class PermissionPage extends Page<Permission>{
	
	/**Ȩ������*/
	private String permissionName;
	
	/**Ȩ��λ*/
	private String permissionBit;
	
	/**����Ȩ��ID*/
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
