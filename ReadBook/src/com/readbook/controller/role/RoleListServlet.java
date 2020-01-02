package com.readbook.controller.role;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.readbook.page.RolePage;
import com.readbook.service.RoleService;
import com.readbook.service.impl.RoleServiceImpl;

/**
 * ��ɫ�б�
 * @author ����
 */
@WebServlet("/RoleListServlet")
public class RoleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private RoleService roleService = new RoleServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String current = request.getParameter("page");
		String limit = request.getParameter("limit");
		String roleName = request.getParameter("roleName");
		RolePage page = new RolePage();
		if(current != null && !"".equals(current)){
			page.setCurrent(Long.parseLong(current));
		}
		if(limit != null && !"".equals(limit)){
			page.setLimit(Long.parseLong(limit));
		}
		page.setRoleName(roleName);
		//ͨ��JSONת�����ߣ���Java����ת��ΪJSON�ַ���
		String jsonString = JSONObject.toJSONStringWithDateFormat(roleService.queryPageData(page), "yyyy-MM-dd HH:mm:ss");
		//��ǰ��Ajax��������
		response.getWriter().write(jsonString);
	}
}
