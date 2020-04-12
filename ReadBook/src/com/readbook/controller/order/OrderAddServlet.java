package com.readbook.controller.order;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.readbook.entity.Order;
import com.readbook.enums.CodeMessage;
import com.readbook.response.ResponseResult;
import com.readbook.service.OrderService;
import com.readbook.service.impl.OrderServiceImpl;
import com.readbook.utils.OrderCodeUtil;

/**
 * 移动端添加订单
 * @author 张敏
 */
@WebServlet("/Front/OrderAddServlet")
public class OrderAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OrderService orderService = new OrderServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CodeMessage codeMessage = CodeMessage.BULID;
		String memberId = request.getParameter("memberId");
		if(memberId == null || "".equals(memberId.trim())){
			codeMessage.setMessage("会员ID不能为空");
			response.getWriter().write(JSONObject.toJSONString(ResponseResult.build(codeMessage)));
		}
		String memberCode = request.getParameter("memberCode");
		if(memberCode == null || "".equals(memberCode)){
			codeMessage.setMessage("会员编号不能为空");
			response.getWriter().write(JSONObject.toJSONString(ResponseResult.build(codeMessage)));
		}
		String shopId = request.getParameter("shopId");
		if(shopId == null || "".equals(shopId)){
			codeMessage.setMessage("门店ID不能为空");
			response.getWriter().write(JSONObject.toJSONString(ResponseResult.build(codeMessage)));
		}
		String bookCaseId = request.getParameter("bookCaseId");
		if(bookCaseId == null || "".equals(bookCaseId)){
			codeMessage.setMessage("书柜ID不能为空");
			response.getWriter().write(JSONObject.toJSONString(ResponseResult.build(codeMessage)));
		}
		String bookId = request.getParameter("bookId");
		if(bookId == null || "".equals(bookId)){
			codeMessage.setMessage("书籍ID");
			response.getWriter().write(JSONObject.toJSONString(ResponseResult.build(codeMessage)));
		}
		
		
		Order order = new Order();
		order.setMemberId(Long.valueOf(memberId));
		order.setMemberCode(memberCode);
		order.setShopId(Long.valueOf(shopId));
		order.setBookCaseId(Long.valueOf(bookCaseId));
		//订单编号
		order.setOrderCode(OrderCodeUtil.makeOrderCode());
		//书店名称
		String shopName = request.getParameter("shopName");
		order.setShopName(shopName);
		//书柜编号
		String bookCaseNumber = request.getParameter("bookCaseNumber");
		order.setBookCaseNumber(bookCaseNumber);
		//书籍编号
		String bookNumber = request.getParameter("bookNumber");
		order.setBookNumber(bookNumber);
		//书籍名称
		String bookName = request.getParameter("bookName");
		order.setBookName(bookName);
		//书籍作者
		String author = request.getParameter("author");
		order.setAuthor(author);
		//书籍价格
		String price = request.getParameter("price");
		if(price != null && !"".equals(price.trim())){
			order.setPrice(new BigDecimal(price));
		}
		//支付金额
		String payAmount = request.getParameter("payAmount");
		if(payAmount != null && !"".equals(payAmount)){
			order.setPayAmount(new BigDecimal(payAmount));
		}
		//订单状态设置为0未确认状态
		order.setState(0);
		orderService.save(order);
		response.getWriter().write(JSONObject.toJSONString(ResponseResult.ok()));
	}

}
