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
 * �ƶ�����Ӷ���
 * @author ����
 */
@WebServlet("/Front/OrderAddServlet")
public class OrderAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OrderService orderService = new OrderServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CodeMessage codeMessage = CodeMessage.BULID;
		String memberId = request.getParameter("memberId");
		if(memberId == null || "".equals(memberId.trim())){
			codeMessage.setMessage("��ԱID����Ϊ��");
			response.getWriter().write(JSONObject.toJSONString(ResponseResult.build(codeMessage)));
		}
		String memberCode = request.getParameter("memberCode");
		if(memberCode == null || "".equals(memberCode)){
			codeMessage.setMessage("��Ա��Ų���Ϊ��");
			response.getWriter().write(JSONObject.toJSONString(ResponseResult.build(codeMessage)));
		}
		String shopId = request.getParameter("shopId");
		if(shopId == null || "".equals(shopId)){
			codeMessage.setMessage("�ŵ�ID����Ϊ��");
			response.getWriter().write(JSONObject.toJSONString(ResponseResult.build(codeMessage)));
		}
		String bookCaseId = request.getParameter("bookCaseId");
		if(bookCaseId == null || "".equals(bookCaseId)){
			codeMessage.setMessage("���ID����Ϊ��");
			response.getWriter().write(JSONObject.toJSONString(ResponseResult.build(codeMessage)));
		}
		String bookId = request.getParameter("bookId");
		if(bookId == null || "".equals(bookId)){
			codeMessage.setMessage("�鼮ID");
			response.getWriter().write(JSONObject.toJSONString(ResponseResult.build(codeMessage)));
		}
		
		
		Order order = new Order();
		order.setMemberId(Long.valueOf(memberId));
		order.setMemberCode(memberCode);
		order.setShopId(Long.valueOf(shopId));
		order.setBookCaseId(Long.valueOf(bookCaseId));
		//�������
		order.setOrderCode(OrderCodeUtil.makeOrderCode());
		//�������
		String shopName = request.getParameter("shopName");
		order.setShopName(shopName);
		//�����
		String bookCaseNumber = request.getParameter("bookCaseNumber");
		order.setBookCaseNumber(bookCaseNumber);
		//�鼮���
		String bookNumber = request.getParameter("bookNumber");
		order.setBookNumber(bookNumber);
		//�鼮����
		String bookName = request.getParameter("bookName");
		order.setBookName(bookName);
		//�鼮����
		String author = request.getParameter("author");
		order.setAuthor(author);
		//�鼮�۸�
		String price = request.getParameter("price");
		if(price != null && !"".equals(price.trim())){
			order.setPrice(new BigDecimal(price));
		}
		//֧�����
		String payAmount = request.getParameter("payAmount");
		if(payAmount != null && !"".equals(payAmount)){
			order.setPayAmount(new BigDecimal(payAmount));
		}
		//����״̬����Ϊ0δȷ��״̬
		order.setState(0);
		orderService.save(order);
		response.getWriter().write(JSONObject.toJSONString(ResponseResult.ok()));
	}

}
