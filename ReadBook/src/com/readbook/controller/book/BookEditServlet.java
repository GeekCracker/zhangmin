package com.readbook.controller.book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.readbook.entity.Book;
import com.readbook.enums.CodeMessage;
import com.readbook.response.ResponseResult;
import com.readbook.service.BookService;
import com.readbook.service.impl.BookServiceImpl;

/**
 * 根据ID修改书籍
 * @author 张敏
 */
@WebServlet("/BookEditServlet")
public class BookEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BookService bookService = new BookServiceImpl();
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id == null || "".equals(id.trim())){
			response.getWriter().write(JSONObject.toJSONString(ResponseResult.build(CodeMessage.ID_BLANK)));
		}
		Book book = new Book();
		String bookName = request.getParameter("bookName");
		book.setBookName(bookName);
		String number = request.getParameter("number");
		book.setNumber(number);
		String shopId = request.getParameter("shopId");
		if(shopId != null && !"".equals(shopId.trim())){
			book.setShopId(Long.valueOf(shopId));
		}
		String bookCaseId = request.getParameter("bookCaseId");
		if(bookCaseId != null && !"".equals(bookCaseId.trim())){
			book.setBookCaseId(Long.valueOf(bookCaseId));
		}
		String author = request.getParameter("author");
		book.setAuthor(author);
		bookService.updateById(book);
		response.getWriter().write(JSONObject.toJSONString(ResponseResult.ok()));
	}

}
