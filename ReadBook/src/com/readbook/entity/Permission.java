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
	
	/**Ȩ��λ*/
	private String permissionBit;
	
	/**Ȩ��URL*/
	private String url;
	
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

	public String getPermissionBit() {
		return permissionBit;
	}

	public void setPermissionBit(String permissionBit) {
		this.permissionBit = permissionBit;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
