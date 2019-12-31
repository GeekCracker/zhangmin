package com.readbook.enums;

public enum CodeMessage {

	SUCCESS(200,"�����ɹ�"),
	
	USERNAME_PASSWORD_ERROR(10001,"�û��������벻��ȷ"),
	
	UNKNOWN(-1,"ϵͳ�쳣...");

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