package com.readbook.entity;

import java.util.List;

/**
 * Ȩ��ʵ����
 * @author ����
 */
public class Permission {

	/**����ID*/
	private Long id;
	
	/**Ȩ������*/
	private String permissionName;
	
	/**����ID*/
	private Long parentId;

	/**�Ӽ�Ȩ���б�*/
	private List<Permission> children;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public List<Permission> getChildren() {
		return children;
	}

	public void setChildren(List<Permission> children) {
		this.children = children;
	}
}
