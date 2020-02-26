package com.readbook.controller.shop;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.readbook.page.ShopPage;
import com.readbook.service.ShopService;
import com.readbook.service.impl.ShopServiceImpl;


/**
 * 门店分页列表Servlet
 * @author 张敏
 */
@WebServlet("/ShopListServlet")
public class ShopListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ShopService shopService = new ShopServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String current = request.getParameter("page");//当前页码
		String limit = request.getParameter("limit");//每页显示多少条数据
		String shopName = request.getParameter("shopName");
		
		ShopPage page = new ShopPage();
		if(current != null && !"".equals(current.trim())){
			page.setCurrent(Long.valueOf(current));
		}
		if(limit != null && !"".equals(limit.trim())){
			page.setLimit(Long.valueOf(limit));
		}
		page.setShopName(shopName);
		//通过JSON转换工具，将Java对象转换为JSON字符串
		String jsonString = JSONObject.toJSONStringWithDateFormat(shopService.queryPageData(page), "yyyy-MM-dd HH:mm:ss");
		//向前端Ajax发送数据
		response.getWriter().write(jsonString);
	}

}
