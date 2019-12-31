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
 * Ȩ���б�Servlet
 */
@WebServlet("/PermissionListServlet")
public class PermissionListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private PermissionService permissionService = new PermissionServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String current = request.getParameter("current");
		String size = request.getParameter("size");
		PermissionPage page = new PermissionPage();
		if(current != null && !"".equals(current)){
			page.setCurrent(Long.parseLong(current));
		}
		if(size != null && !"".equals(size)){
			page.setSize(Long.parseLong(size));
		}
		//ͨ��JSONת�����ߣ���Java����ת��ΪJSON�ַ���
		String jsonString = JSONObject.toJSONStringWithDateFormat(permissionService.queryPageData(page), "yyyy-MM-dd HH:mm:ss");
		//��ǰ��Ajax��������
		response.getWriter().write(jsonString);
	}
}
