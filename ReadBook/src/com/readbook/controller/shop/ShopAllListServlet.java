package com.readbook.controller.shop;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.readbook.response.ResponseResult;
import com.readbook.service.ShopService;
import com.readbook.service.impl.ShopServiceImpl;

/**
 * 获取所有门店Servlet
 * @author 张敏
 */
@WebServlet("/ShopAllListServlet")
public class ShopAllListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ShopService shopService = new ShopServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write(JSONObject.toJSONStringWithDateFormat(ResponseResult.ok(shopService.queryAll()), "yyyy-MM-dd HH:mm:ss"));
	}
}
