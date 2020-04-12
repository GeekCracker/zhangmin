package com.readbook.entity;

import java.util.Date;

/**
 * 会员实体类
 * @author 张敏
 */
public class Member{
	
	/**主键ID*/
	private Long id;
	
	/**会员编号*/
	private String memberCode;
	
	/**会员真实姓名*/
	private String name;
	
	/**会员昵称*/
	private String nickName;

	/**会员手机号码*/
	private String phone;
	
	/**会员登陆密码*/
	private String password;
	
	/**性别*/
	private String sex;
	
	/**年龄*/
	private Integer age;
	
	/**头像图片*/
	private String headImage;
	
	/**创建时间*/
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
