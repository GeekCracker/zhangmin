package com.readbook.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.readbook.entity.User;
import com.readbook.enums.CodeMessage;
import com.readbook.response.ResponseResult;
import com.readbook.service.UserService;
import com.readbook.service.impl.UserServiceImpl;

/**
 * 用户登录
 * @author 张敏
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService = new UserServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try{
			User user = userService.login(username, password);
			if(user != null){
				//如果用户不为空，表示根据用户名与密码可以查询到用户，即允许登陆
				request.setAttribute("data",ResponseResult.ok(user));
				request.getRequestDispatcher("/page/main.jsp").forward(request, response);
			}else {
				request.setAttribute("data",ResponseResult.build(CodeMessage.USERNAME_PASSWORD_ERROR));
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}catch(Exception e){
			request.setAttribute("data",ResponseResult.unkonwn());
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
