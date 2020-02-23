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
 * 用户列表Servlet
 */
@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String current = request.getParameter("page");
		String limit = request.getParameter("limit");
		String username = request.getParameter("username");
		String phone = request.getParameter("phone");
		UserPage page = new UserPage();
		if(current != null && !"".equals(current)){
			page.setCurrent(Long.parseLong(current));
		}
		if(limit != null && !"".equals(limit)){
			page.setLimit(Long.parseLong(limit));
		}
		if(username != null && !"".equals(username.trim())){
			page.setUsername(username);
		}
		if(phone != null && !"".equals(phone.trim())){
			page.setPhone(phone);
		}
		//通过JSON转换工具，将Java对象转换为JSON字符串
		String jsonString = JSONObject.toJSONStringWithDateFormat(userService.queryPageData(page), "yyyy-MM-dd HH:mm:ss");
		//向前端Ajax发送数据
		response.getWriter().write(jsonString);
	}
}
