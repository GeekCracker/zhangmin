package com.readbook.entity;

import java.util.List;

/**
 * 权限实体类
 * @author 张敏
 */
public class Permission {

	/**主键ID*/
	private Long id;
	
	/**权限名称*/
	private String permissionName;
	
	/**权限位*/
	private String permissionBit;
	
	/**权限URL*/
	private String url;
	
	/**父级ID*/
	private Long parentId;

	/**子级权限列表*/
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
