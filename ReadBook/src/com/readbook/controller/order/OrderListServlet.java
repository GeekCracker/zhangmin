package com.readbook.controller.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.readbook.page.OrderPage;
import com.readbook.service.OrderService;
import com.readbook.service.impl.OrderServiceImpl;

/**
 * 订单列表
 * @author 张敏
 */
@WebServlet("/OrderListServlet")
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private OrderService orderService = new OrderServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String current = request.getParameter("page");
		String limit = request.getParameter("limit");
		
		OrderPage page = new OrderPage();
		if(current != null && !"".equals(current.trim())){
			page.setCurrent(Long.valueOf(current));
		}
		if(limit != null && !"".equals(limit.trim())){
			page.setLimit(Long.valueOf(limit));
		}
		String orderCode = request.getParameter("orderCode");
		if(orderCode != null && !"".equals(orderCode.trim())){
			page.setOrderCode(orderCode);
		}
		String shopId = request.getParameter("shopId");
		if(shopId != null && !"".equals(shopId.trim())){
			page.setShopId(Long.valueOf(shopId));
		}
		String bookCaseId = request.getParameter("bookCaseId");
		if(bookCaseId != null && !"".equals(bookCaseId.trim())){
			page.setBookCaseId(Long.valueOf(bookCaseId));
		}
		String bookNumber = request.getParameter("bookNumber");
		if(bookNumber != null && !"".equals(bookNumber.trim())){
			page.setBookNumber(bookNumber);
		}
		String memberCode = request.getParameter("memberCode");
		if(memberCode != null && !"".equals(memberCode.trim())){
			page.setMemberCode(memberCode);
		}
		String phone = request.getParameter("phone");
		if(phone != null && !"".equals(phone.trim())){
			page.setPhone(phone);
		}
		response.getWriter().write(JSONObject.toJSONStringWithDateFormat(orderService.queryPageData(page), "yyyy-MM-dd HH:mm:ss"));
	}

}
