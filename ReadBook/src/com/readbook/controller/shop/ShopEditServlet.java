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
 * 根据ID修改门店信息Servlet
 */
@WebServlet("/ShopEditServlet")
public class ShopEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ShopService shopService = new ShopServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id == null || "".equals(id.trim())){
			//如果ID为空，则提示ID为空
			response.getWriter().write(JSONObject.toJSONString(ResponseResult.build(CodeMessage.ID_BLANK)));
		}
		//接收门店信息参数，并赋值给门店实例对象
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
		//执行修改操作
		shopService.updateById(shop);
		//返回操作成功的信息
		response.getWriter().write(JSONObject.toJSONString(ResponseResult.ok()));
	}

}
