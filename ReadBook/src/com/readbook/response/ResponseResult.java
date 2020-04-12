package com.readbook.response;

import com.readbook.enums.CodeMessage;

/**
 * @author ����
 *	��������DTO�����ݴ�����󣩣�������װ���ص�����
 */
public class ResponseResult {

	/**״̬��*/
	private Integer code;
	
	/**����״̬��ʾ���磺�����ɹ�������ʧ��*/
	private String msg;
	
	/**��ѯ���������������ڷ�ҳ�б��л��õ�*/
	private Long count;
	
	/**���ظ�ǰ̨ҳ������ݶ��󣬿����ǵ������ݣ�Ҳ�������б�����*/
	private Object data;

	public ResponseResult() {
		super();
	}

	public ResponseResult(Integer code,String msg){
		this.code = code;
		this.msg = msg;
	}
	
	public ResponseResult(Integer code,String msg,Object data){
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	public ResponseResult(Integer code,String msg,Object data,Long count){
		this.code = code;
		this.msg = msg;
		this.data = data;
		this.count = count;
	}
	
	public static ResponseResult ok(){
		return new ResponseResult(CodeMessage.SUCCESS.getCode(),CodeMessage.SUCCESS.getMessage());
	}
	
	public static ResponseResult ok(Object data){
		return new ResponseResult(CodeMessage.SUCCESS.getCode(),CodeMessage.SUCCESS.getMessage(),data);
	}
	
	public static ResponseResult ok(Object data,Long count){
		return new ResponseResult(0,CodeMessage.SUCCESS.getMessage(),data,count);
	}
	
	public static ResponseResult unkonwn(){
		return new ResponseResult(CodeMessage.UNKNOWN.getCode(),CodeMessage.UNKNOWN.getMessage());
	}
	
	public static ResponseResult unknown(Object data){
		return new ResponseResult(CodeMessage.UNKNOWN.getCode(),CodeMessage.UNKNOWN.getMessage(),data);
	}
	
	public static ResponseResult build(CodeMessage codeMessage){
		return new ResponseResult(codeMessage.getCode(),codeMessage.getMessage());
	}
	
	public static ResponseResult build(CodeMessage codeMessage,Object data){
		return new ResponseResult(codeMessage.getCode(),codeMessage.getMessage(),data);
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
