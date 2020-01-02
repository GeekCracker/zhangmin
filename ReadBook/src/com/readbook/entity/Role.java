package com.readbook.entity;

import java.util.List;

public class Role {

	/**����ID*/
	private Long id;
	
	/**��ɫ����*/
	private String roleName;
	
	/**�Ƿ�����*/
	private Boolean enable;
	
	/**Ȩ��ID�б�*/
	private String permissionIds;
	
	/**Ȩ���б�*/
	private List<Permission> permissions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public String getPermissionIds() {
		return permissionIds;
	}

	public void setPermissionIds(String permissionIds) {
		this.permissionIds = permissionIds;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
}
