package com.readbook.controller.role;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.readbook.entity.Role;
import com.readbook.response.ResponseResult;
import com.readbook.service.RoleService;
import com.readbook.service.impl.RoleServiceImpl;

/**
 * ��ȡ���еĽ�ɫ��Servlet
 * @author ����
 */
@WebServlet("/RoleAllListServlet")
public class RoleAllListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private RoleService roleService = new RoleServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Role> roles = roleService.queryAll();
		response.getWriter().write(JSONObject.toJSONString(ResponseResult.ok(roles)));
	}
}
