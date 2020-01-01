package com.readbook.controller.permission;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.readbook.response.ResponseResult;
import com.readbook.service.PermissionService;
import com.readbook.service.impl.PermissionServiceImpl;

/**
 * »®œﬁ ˜
 * @author ’≈√Ù
 */
@WebServlet("/PermissionTreeServlet")
public class PermissionTreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PermissionService permissionService = new PermissionServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write(JSONObject.toJSONString( ResponseResult.ok(permissionService.permissionTree())));
	}
}
