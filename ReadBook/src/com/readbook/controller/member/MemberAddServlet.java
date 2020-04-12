package com.readbook.controller.member;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.readbook.entity.Member;
import com.readbook.response.ResponseResult;
import com.readbook.service.MemberService;
import com.readbook.service.impl.MemberServiceImpl;

/**
 * 会员添加注册
 * @author 张敏
 */
@WebServlet("/MemberAddServlet")
public class MemberAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService memberService = new MemberServiceImpl();
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = new Member();
		
		String memberCode = request.getParameter("memberCode");
		if(memberCode != null && !"".equals(memberCode)){
			member.setMemberCode(memberCode);
		}
		String name = request.getParameter("name");
		if(name != null && !"".equals(name)){
			member.setName(name);
		}
		String nickName = request.getParameter("nickName");
		if(nickName != null && !"".equals(nickName)){
			member.setNickName(nickName);
		}
		String phone = request.getParameter("phone");
		if(phone != null && !"".equals(phone)){
			member.setPhone(phone);
		}
		String password = request.getParameter("password");
		if(password != null && !"".equals(password)){
			member.setPassword(password);
		}
		String sex = request.getParameter("sex");
		if(sex != null && !"".equals(sex)){
			member.setSex(sex);
		}
		String age = request.getParameter("age");
		if(age != null && !"".equals(age.trim())){
			member.setAge(Integer.valueOf(age));
		}
		String headImage = request.getParameter("headImage");
		if(headImage != null && !"".equals(headImage)){
			member.setHeadImage(headImage);
		}
		member.setCreateTime(new Date());
		memberService.save(member);
		response.getWriter().write(JSONObject.toJSONString(ResponseResult.ok()));
	}

}
