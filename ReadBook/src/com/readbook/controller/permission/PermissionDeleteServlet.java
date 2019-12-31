package com.readbook.controller.permission;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.readbook.enums.CodeMessage;
import com.readbook.response.ResponseResult;
import com.readbook.service.PermissionService;
import com.readbook.service.impl.PermissionServiceImpl;

/**
 * …æ≥˝»®œﬁ
 * @author ’≈√Ù
 */
@WebServlet("/PermissionDeleteServlet")
public class PermissionDeleteServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private PermissionService permissionService = new PermissionServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id == null || "".equals(id)){
			response.getWriter().write(JSONObject.toJSONString(ResponseResult.build(CodeMessage.ID_BLANK)));
		}
		permissionService.deleteById(Long.valueOf(id));
		response.getWriter().write(JSONObject.toJSONString(ResponseResult.ok()));
	}
}
