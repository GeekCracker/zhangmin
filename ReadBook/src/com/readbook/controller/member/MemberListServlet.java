package com.readbook.controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.readbook.page.MemberPage;
import com.readbook.service.MemberService;
import com.readbook.service.impl.MemberServiceImpl;

/**
 * 会员列表查询
 * @author 张敏
 */
@WebServlet("/MemberListServlet")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MemberService memberService = new MemberServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String current = request.getParameter("page");
		String limit = request.getParameter("limit");
		MemberPage page = new MemberPage();
		if(current != null && !"".equals(current.trim())){
			page.setCurrent(Long.valueOf(current));
		}
		if(limit != null && !"".equals(limit.trim())){
			page.setLimit(Long.valueOf(limit));
		}
		String memberCode = request.getParameter("memberCode");
		if(memberCode != null && !"".equals(memberCode.trim())){
			page.setMemberCode(memberCode);
		}
		String name = request.getParameter("name");
		if(name != null && !"".equals(name.trim())){
			page.setName(name);
		}
		String nickName = request.getParameter("nickName");
		if(nickName != null && !"".equals(nickName.trim())){
			page.setNickName(nickName);
		}
		String phone = request.getParameter("phone");
		if(phone != null && !"".equals(phone.trim())){
			page.setPhone(phone);
		}
		response.getWriter().write(JSONObject.toJSONStringWithDateFormat(memberService.queryPageData(page), "yyyy-MM-dd HH:mm:ss"));
	}

}
