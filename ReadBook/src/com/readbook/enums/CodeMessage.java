package com.readbook.enums;

/**
 * @author 张敏
 *	操作信息
 */
public enum CodeMessage {

	SUCCESS(200,"操作成功"),
	
	USERNAME_PASSWORD_ERROR(10001,"用户名或密码不正确"),
	ID_BLANK(10002,"ID为空"),
	
	SHOP_NAME_BLANK(20001,"门店名称不能为空"),
	
	BOOK_CASE_NUMBER_BLANK(30001,"书柜编号不能为空"),
	
	BOOK_NAME_BLANK(40001,"书籍名称不能为空"),
	
	BULID(-2,""),
	
	UNKNOWN(-1,"系统异常...");

	private Integer code;
	
	private String message;
	
	private CodeMessage(Integer code,String message){
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
