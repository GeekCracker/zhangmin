package com.readbook.controller.shop;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.readbook.enums.CodeMessage;
import com.readbook.response.ResponseResult;
import com.readbook.service.ShopService;
import com.readbook.service.impl.ShopServiceImpl;

/**
 * ����IDɾ���ŵ�Servlet
 */
@WebServlet("/ShopDeleteServlet")
public class ShopDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ShopService shopService = new ShopServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id == null || "".equals(id.trim())){
			//���IDΪ�գ�����ʾ�Ĳ���ID����Ϊ��
			response.getWriter().write(JSONObject.toJSONString(ResponseResult.build(CodeMessage.ID_BLANK)));
		}
		shopService.deleteById(Long.valueOf(id));
		//���ز����ɹ�����Ϣ
		response.getWriter().write(JSONObject.toJSONString(ResponseResult.ok()));
	}


}
