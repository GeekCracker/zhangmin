package com.readbook.entity;

import java.util.Date;

/**
 * ��Աʵ����
 * @author ����
 */
public class Member{
	
	/**����ID*/
	private Long id;
	
	/**��Ա���*/
	private String memberCode;
	
	/**��Ա��ʵ����*/
	private String name;
	
	/**��Ա�ǳ�*/
	private String nickName;

	/**��Ա�ֻ�����*/
	private String phone;
	
	/**��Ա��½����*/
	private String password;
	
	/**�Ա�*/
	private String sex;
	
	/**����*/
	private Integer age;
	
	/**ͷ��ͼƬ*/
	private String headImage;
	
	/**����ʱ��*/
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
