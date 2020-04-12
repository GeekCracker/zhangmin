package com.readbook.controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.readbook.entity.Member;
import com.readbook.enums.CodeMessage;
import com.readbook.response.ResponseResult;
import com.readbook.service.MemberService;
import com.readbook.service.impl.MemberServiceImpl;

/**
 * 会员修改
 * @author 张敏
 */
@WebServlet("/MemberEditServlet")
public class MemberEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService memberService = new MemberServiceImpl();
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id == null || "".equals(id.trim())){
			response.getWriter().write(JSONObject.toJSONString(ResponseResult.build(CodeMessage.ID_BLANK)));
		}
		Member member = new Member();
		member.setId(Long.valueOf(id));
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
		memberService.updateById(member);
		response.getWriter().write(JSONObject.toJSONString(ResponseResult.ok()));
	}

}
