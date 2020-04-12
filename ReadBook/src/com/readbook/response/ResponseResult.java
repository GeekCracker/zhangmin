package com.readbook.response;

import com.readbook.enums.CodeMessage;

/**
 * @author 张敏
 *	返回数据DTO（数据传输对象），用来组装返回的数据
 */
public class ResponseResult {

	/**状态码*/
	private Integer code;
	
	/**操作状态提示例如：操作成功、操作失败*/
	private String msg;
	
	/**查询到的数据总数，在分页列表中会用到*/
	private Long count;
	
	/**返回给前台页面的数据对象，可以是单条数据，也可以是列表数据*/
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
