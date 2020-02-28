package com.readbook.controller.bookCase;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.readbook.service.BookCaseService;
import com.readbook.service.impl.BookCaseServiceImpl;

/**
 * 根据条件查询书柜列表
 * @author 张敏
 */
@WebServlet("/BookCaseParamListServlet")
public class BookCaseParamListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BookCaseService bookCaseService = new BookCaseServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String shopId = request.getParameter("shopId");
		
		Map<String,Object> param = new LinkedHashMap<String,Object>();
		if(shopId != null && !"".equals(shopId.trim())){
			param.put("shopId",Long.valueOf(shopId));
		}
		response.getWriter().write(JSONObject.toJSONStringWithDateFormat(bookCaseService.queryData(param), "yyyy-MM-dd HH:mm:ss"));
	}

}
