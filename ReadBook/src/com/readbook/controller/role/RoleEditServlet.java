package com.readbook.controller.role;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.readbook.entity.Role;
import com.readbook.enums.CodeMessage;
import com.readbook.response.ResponseResult;
import com.readbook.service.RoleService;
import com.readbook.service.impl.RoleServiceImpl;

/**
 * ½ÇÉ«ÐÞ¸Ä
 * @author ÕÅÃô
 */
@WebServlet("/RoleEditServlet")
public class RoleEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private RoleService roleService = new RoleServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String roleName = request.getParameter("roleName");
		String enable = request.getParameter("enable");
		String permissionIds = request.getParameter("permissionIds");
		if(id == null || "".equals(id)){
			response.getWriter().write(JSONObject.toJSONString(ResponseResult.build(CodeMessage.ID_BLANK)));
		}
		Role role = new Role();
		role.setId(Long.valueOf(id));
		role.setRoleName(roleName);
		role.setPermissionIds(permissionIds);
		if(enable != null && !"".equals(enable.trim())){
			if("1".equals(enable)){
				role.setEnable(true);
			}else {
				role.setEnable(false);
			}
		}
		roleService.updateById(role);
		response.getWriter().write(JSONObject.toJSONString(ResponseResult.ok()));
	}
}
