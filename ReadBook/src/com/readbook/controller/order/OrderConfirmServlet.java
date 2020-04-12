package com.readbook.controller.order;

import java.io.IOException;
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

/**
 * 确认订单
 * @author 张敏
 */
@WebServlet("/Front/OrderConfirmServlet")
public class OrderConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private OrderService orderService = new OrderServiceImpl();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//订单ID
		String id = request.getParameter("id");
		if(id == null || "".equals(id.trim())){
			response.getWriter().write(JSONObject.toJSONString(ResponseResult.build(CodeMessage.ID_BLANK)));
		}
		Order order = new Order();
		order.setId(Long.valueOf(id));
		order.setState(1);
		orderService.updateById(order);
		response.getWriter().write(JSONObject.toJSONString(ResponseResult.ok()));
	}
}
