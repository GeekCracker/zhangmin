package com.readbook.controller.permission;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.readbook.entity.Permission;
import com.readbook.enums.CodeMessage;
import com.readbook.response.ResponseResult;
import com.readbook.service.PermissionService;
import com.readbook.service.impl.PermissionServiceImpl;

/**
 * ÐÞ¸ÄÈ¨ÏÞServlet
 */
@WebServlet("/PermissionUpdateServlet")
public class PermissionUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PermissionService permissionService = new PermissionServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String permissionName = request.getParameter("permissionName");
		String parentId = request.getParameter("parentId");
		if(id == null || "".equals(id)){
			response.getWriter().write(JSONObject.toJSONString(ResponseResult.build(CodeMessage.ID_BLANK)));
		}
		Permission permission = new Permission();
		permission.setId(Long.valueOf(id));
		if(parentId != null && !"".equals(id)){
			permission.setParentId(Long.valueOf(parentId));	
		}
		permission.setPermissionName(permissionName);
		permissionService.updateById(permission);
		response.getWriter().write(JSONObject.toJSONString(ResponseResult.ok()));
	}

}
