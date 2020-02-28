package com.readbook.controller.bookCase;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.readbook.entity.BookCase;
import com.readbook.enums.CodeMessage;
import com.readbook.response.ResponseResult;
import com.readbook.service.BookCaseService;
import com.readbook.service.impl.BookCaseServiceImpl;

/**
 * ÃÌº” ÈπÒ
 * @author ’≈√Ù
 */
@WebServlet("/BookCaseAddServlet")
public class BookCaseAddServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private BookCaseService bookCaseService = new BookCaseServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String number = request.getParameter("number");
		if(number == null || "".equals(number.trim())){
			response.getWriter().write(JSONObject.toJSONString(ResponseResult.build(CodeMessage.BOOK_CASE_NUMBER_BLANK)));
		}
		String shopId = request.getParameter("shopId");
		
		BookCase bookCase = new BookCase();
		bookCase.setNumber(number);
		if(shopId != null && !"".equals(shopId.trim())){
			bookCase.setShopId(Long.valueOf(shopId));
		}
		
		bookCaseService.save(bookCase);
		response.getWriter().write(JSONObject.toJSONString(ResponseResult.ok()));
	}

	
}
