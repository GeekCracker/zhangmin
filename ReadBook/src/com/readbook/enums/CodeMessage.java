package com.readbook.enums;

public enum CodeMessage {

	SUCCESS(200,"操作成功"),
	
	USERNAME_PASSWORD_ERROR(10001,"用户名或密码不正确"),
	ID_BLANK(10002,"ID为空"),
	
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
