package com.readbook.controller.book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.readbook.page.BookPage;
import com.readbook.service.BookService;
import com.readbook.service.impl.BookServiceImpl;

/**
 * 书籍分页列表
 * @author 张敏
 */
@WebServlet("/BookListServlet")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private BookService bookService = new BookServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String current = request.getParameter("page");
		String limit = request.getParameter("limit");
		
		BookPage page = new BookPage();
		if(current != null && !"".equals(current.trim())){
			page.setCurrent(Long.valueOf(current));
		}
		if(limit != null && !"".equals(limit.trim())){
			page.setLimit(Long.valueOf(limit));
		}
		
		String shopId = request.getParameter("shopId");
		if(shopId != null && !"".equals(shopId.trim())){
			page.setShopId(Long.valueOf(shopId));
		}
		String bookCaseId = request.getParameter("bookCaseId");
		if(bookCaseId != null && !"".equals(bookCaseId.trim())){
			page.setBookCaseId(Long.valueOf(bookCaseId));
		}
		String bookName = request.getParameter("bookName");
		page.setBookName(bookName);
		String number = request.getParameter("number");
		page.setNumber(number);
		String author = request.getParameter("author");
		page.setAuthor(author);
		
		response.getWriter().write(JSONObject.toJSONStringWithDateFormat(bookService.queryPageData(page), "yyyy-MM-dd HH:mm:ss"));
	}

}
