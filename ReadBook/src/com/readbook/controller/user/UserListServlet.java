package com.readbook.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.readbook.page.UserPage;
import com.readbook.service.UserService;
import com.readbook.service.impl.UserServiceImpl;

/**
 * �û��б�Servlet
 */
@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String current = request.getParameter("page");
		String limit = request.getParameter("limit");
		UserPage page = new UserPage();
		if(current != null && !"".equals(current)){
			page.setCurrent(Long.parseLong(current));
		}
		if(limit != null && !"".equals(limit)){
			page.setLimit(Long.parseLong(limit));
		}
		//ͨ��JSONת�����ߣ���Java����ת��ΪJSON�ַ���
		String jsonString = JSONObject.toJSONStringWithDateFormat(userService.queryPageData(page), "yyyy-MM-dd HH:mm:ss");
		//��ǰ��Ajax��������
		response.getWriter().write(jsonString);
	}
}
