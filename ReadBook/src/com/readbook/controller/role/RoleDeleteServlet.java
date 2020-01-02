package com.readbook.controller.role;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.readbook.enums.CodeMessage;
import com.readbook.response.ResponseResult;
import com.readbook.service.RoleService;
import com.readbook.service.impl.RoleServiceImpl;

/**
 * ½ÇÉ«É¾³ý
 * @author ÕÅÃô
 */
@WebServlet("/RoleDeleteServlet")
public class RoleDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RoleService roleService = new RoleServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id == null || "".equals(id.trim())){
			response.getWriter().write(JSONObject.toJSONString(ResponseResult.build(CodeMessage.ID_BLANK)));
		}
		roleService.deleteById(Long.valueOf(id));
		response.getWriter().write(JSONObject.toJSONString(ResponseResult.ok()));
	}

}
