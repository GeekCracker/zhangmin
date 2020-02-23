package com.readbook.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.readbook.entity.User;
import com.readbook.response.ResponseResult;
import com.readbook.service.UserService;
import com.readbook.service.impl.UserServiceImpl;

/**
 * ����û�
 * @author ����
 */
@WebServlet("/UserAddServlet")
public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String phone = request.getParameter("phone");
		User user = new User();
		user.setUsername(username);
		user.setPhone(phone);
		user.setPassword("123456");//����û�ʱĬ�ϳ�ʼ����
		userService.save(user);
		//ͨ��response��д�����ɹ�����Ϣ
		response.getWriter().write(JSONObject.toJSONString(ResponseResult.ok()));
	}
}
