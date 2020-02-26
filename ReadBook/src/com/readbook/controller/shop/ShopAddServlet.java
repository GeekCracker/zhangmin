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
 * ����ŵ�Servlet
 * @author ����
 */
@WebServlet("/ShopAddServlet")
public class ShopAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ShopService shopService  = new ShopServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String shopName = request.getParameter("shopName");
		String address = request.getParameter("address");
		if(shopName == null || "".equals(shopName.trim())){
			//����ŵ�����Ϊ�գ�����ʾ�ŵ����Ʋ���Ϊ�յ���Ϣ
			response.getWriter().write(JSONObject.toJSONString(ResponseResult.build(CodeMessage.SHOP_NAME_BLANK)));
		}
		Shop shop = new Shop();
		shop.setShopName(shopName);
		shop.setAddress(address);
		shopService.save(shop);
		//����JSON��ʽ�Ĳ����ɹ���Ϣ
		response.getWriter().write(JSONObject.toJSONString(ResponseResult.ok()));
	}

}
