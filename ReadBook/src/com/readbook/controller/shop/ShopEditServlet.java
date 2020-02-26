package com.readbook.controller.shop;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.readbook.entity.Shop;
import com.readbook.enums.CodeMessage;
import com.readbook.response.ResponseResult;
import com.readbook.service.ShopService;
import com.readbook.service.impl.ShopServiceImpl;

/**
 * ����ID�޸��ŵ���ϢServlet
 */
@WebServlet("/ShopEditServlet")
public class ShopEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ShopService shopService = new ShopServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id == null || "".equals(id.trim())){
			//���IDΪ�գ�����ʾIDΪ��
			response.getWriter().write(JSONObject.toJSONString(ResponseResult.build(CodeMessage.ID_BLANK)));
		}
		//�����ŵ���Ϣ����������ֵ���ŵ�ʵ������
		Shop shop = new Shop();
		shop.setId(Long.valueOf(id));
		String shopName = request.getParameter("shopName");
		if(shopName != null && !"".equals(shopName.trim())){
			shop.setShopName(shopName);
		}
		String address = request.getParameter("address");
		if(address != null && !"".equals(address.trim())){
			shop.setAddress(address);
		}
		//ִ���޸Ĳ���
		shopService.updateById(shop);
		//���ز����ɹ�����Ϣ
		response.getWriter().write(JSONObject.toJSONString(ResponseResult.ok()));
	}

}
