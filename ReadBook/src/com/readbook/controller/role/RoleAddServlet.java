package com.readbook.controller.role;

import java.io.IOException;
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
 * Ω«…´ÃÌº”
 * @author ’≈√Ù
 */
@WebServlet("/RoleAddServlet")
public class RoleAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RoleService roleService = new RoleServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roleName = request.getParameter("roleName");
		String enable = request.getParameter("enable");
		String permissionIds = request.getParameter("permissionIds");
		
		Role role = new Role();
		role.setRoleName(roleName);
		role.setPermissionIds(permissionIds);
		if(enable != null && "1".equals(enable)){
			role.setEnable(true);
		}else {
			role.setEnable(false);
		}
		roleService.save(role);
		response.getWriter().write(JSONObject.toJSONString(ResponseResult.ok()));
	}

}
