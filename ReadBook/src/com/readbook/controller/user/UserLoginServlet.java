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
 * ”√ªßµ«¬º
 * @author ’≈√Ù
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
				request.setAttribute("data",ResponseResult.ok());
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
