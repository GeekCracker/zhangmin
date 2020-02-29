package com.readbook.controller.book;

import java.io.IOException;
import java.math.BigDecimal;

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
 * ÃÌº” ÈºÆServlet
 * @author ’≈√Ù
 */
@WebServlet("/BookAddServlet")
public class BookAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BookService bookService = new BookServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookName = request.getParameter("bookName");
		if(bookName == null || "".equals(bookName.trim())){
			response.getWriter().write(JSONObject.toJSONString(ResponseResult.build(CodeMessage.BOOK_NAME_BLANK)));
		}
		Book book = new Book();
		book.setBookName(bookName);
		String shopId = request.getParameter("shopId");
		if(shopId != null && !"".equals(shopId.trim())){
			book.setShopId(Long.valueOf(shopId));
		}
		String bookCaseId = request.getParameter("bookCaseId");
		if(bookCaseId != null && !"".equals(bookCaseId.trim())){
			book.setBookCaseId(Long.valueOf(bookCaseId));
		}
		String number = request.getParameter("number");
		book.setNumber(number);
		String author = request.getParameter("author");
		book.setAuthor(author);
		String price = request.getParameter("price");
		if(price != null && !"".equals(price.trim())){
			book.setPrice(new BigDecimal(price));
		}
		bookService.save(book);
		response.getWriter().write(JSONObject.toJSONString(ResponseResult.ok()));
	}

}
