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
 * �ŵ��ҳ�б�Servlet
 * @author ����
 */
@WebServlet("/ShopListServlet")
public class ShopListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ShopService shopService = new ShopServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String current = request.getParameter("page");//��ǰҳ��
		String limit = request.getParameter("limit");//ÿҳ��ʾ����������
		String shopName = request.getParameter("shopName");
		
		ShopPage page = new ShopPage();
		if(current != null && !"".equals(current.trim())){
			page.setCurrent(Long.valueOf(current));
		}
		if(limit != null && !"".equals(limit.trim())){
			page.setLimit(Long.valueOf(limit));
		}
		page.setShopName(shopName);
		//ͨ��JSONת�����ߣ���Java����ת��ΪJSON�ַ���
		String jsonString = JSONObject.toJSONStringWithDateFormat(shopService.queryPageData(page), "yyyy-MM-dd HH:mm:ss");
		//��ǰ��Ajax��������
		response.getWriter().write(jsonString);
	}

}
