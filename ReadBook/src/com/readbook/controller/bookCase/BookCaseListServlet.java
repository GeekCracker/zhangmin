package com.readbook.controller.bookCase;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.readbook.page.BookCasePage;
import com.readbook.service.BookCaseService;
import com.readbook.service.impl.BookCaseServiceImpl;

/**
 * 书柜分页列表
 * @author 张敏
 */
@WebServlet("/BookCaseListServlet")
public class BookCaseListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private BookCaseService bookCaseService = new BookCaseServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String current = request.getParameter("page");
		String limit = request.getParameter("limit");
		String number = request.getParameter("number");
		String shopId = request.getParameter("shopId");
		BookCasePage page = new BookCasePage();
		
		if(current != null && !"".equals(current.trim())){
			page.setCurrent(Long.valueOf(current));
		}
		if(limit != null && !"".equals(limit.trim())){
			page.setLimit(Long.valueOf(limit));
		}
		page.setNumber(number);
		if(shopId != null && !"".equals(shopId.trim())){
			page.setShopId(Long.valueOf(shopId));
		}
		response.getWriter().write(JSONObject.toJSONStringWithDateFormat(bookCaseService.queryPageData(page), "yyyy-MM-dd HH:mm:ss"));
	}
}
