package com.readbook.page;

import com.readbook.entity.Member;

public class MemberPage extends Page<Member>{
	
	/**��Ա���*/
	private String memberCode;
	
	/**��ʵ����*/
	private String name;
	
	/**�ǳ�*/
	private String nickName;
	
	/**��ϵ��ʽ*/
	private String phone;

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
