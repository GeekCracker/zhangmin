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
 * –ﬁ∏ƒ ÈπÒServlet
 * @author ’≈√Ù
 */
@WebServlet("/BookCaseEditServlet")
public class BookCaseEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BookCaseService bookCaseService = new BookCaseServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id == null || "".equals(id.trim())){
			response.getWriter().write(JSONObject.toJSONString(ResponseResult.build(CodeMessage.ID_BLANK)));
		}
		String number = request.getParameter("number");
		if(number == null || "".equals(number.trim())){
			response.getWriter().write(JSONObject.toJSONString(ResponseResult.build(CodeMessage.BOOK_CASE_NUMBER_BLANK)));
		}
		BookCase bookCase = new BookCase();
		bookCase.setId(Long.valueOf(id));
		bookCase.setNumber(number);
		String shopId = request.getParameter("shopId");
		if(shopId != null && !"".equals(shopId.trim())){
			bookCase.setShopId(Long.valueOf(shopId));
		}
		bookCaseService.updateById(bookCase);
		response.getWriter().write(JSONObject.toJSONString(ResponseResult.ok()));
	}

}
