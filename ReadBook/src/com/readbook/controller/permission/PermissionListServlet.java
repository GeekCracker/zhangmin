package com.readbook.controller.permission;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.readbook.page.PermissionPage;
import com.readbook.service.PermissionService;
import com.readbook.service.impl.PermissionServiceImpl;

/**
 * 权限列表Servlet
 */
@WebServlet("/PermissionListServlet")
public class PermissionListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private PermissionService permissionService = new PermissionServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String current = request.getParameter("page");
		String limit = request.getParameter("limit");
		String permissionName = request.getParameter("permissionName");
		String permissionBit = request.getParameter("permissionBit");
		String parentId = request.getParameter("parentId");
		PermissionPage page = new PermissionPage();
		if(current != null && !"".equals(current)){
			page.setCurrent(Long.parseLong(current));
		}
		if(limit != null && !"".equals(limit)){
			page.setLimit(Long.parseLong(limit));
		}
		page.setPermissionName(permissionName);
		page.setPermissionBit(permissionBit);
		if(parentId != null && !"".equals(parentId.trim())){
			page.setParentId(Long.valueOf(parentId));
		}
		//通过JSON转换工具，将Java对象转换为JSON字符串
		String jsonString = JSONObject.toJSONStringWithDateFormat(permissionService.queryPageData(page), "yyyy-MM-dd HH:mm:ss");
		//向前端Ajax发送数据
		response.getWriter().write(jsonString);
	}
}
