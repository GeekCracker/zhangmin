package com.readbook.controller.bookCase;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.readbook.enums.CodeMessage;
import com.readbook.response.ResponseResult;
import com.readbook.service.BookCaseService;
import com.readbook.service.impl.BookCaseServiceImpl;

/**
 * …æ≥˝ ÈπÒServlet
 * @author ’≈√Ù
 */
@WebServlet("/BookCaseDeleteServlet")
public class BookCaseDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BookCaseService bookCaseService = new BookCaseServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id == null || "".equals(id.trim())){
			response.getWriter().write(JSONObject.toJSONString(ResponseResult.build(CodeMessage.ID_BLANK)));
		}
		bookCaseService.deleteById(Long.valueOf(id));
		response.getWriter().write(JSONObject.toJSONString(ResponseResult.ok()));
	}

}
