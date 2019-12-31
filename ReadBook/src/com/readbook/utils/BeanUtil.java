package com.readbook.utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class BeanUtil {

	public static <T> List<T> populate(List<Map<String,Object>> list,Class<T> clazz){
		if(clazz == null){
			throw new NullPointerException("clazz参数不能为空");
		}
		try{
			if(list != null && !list.isEmpty()){
				List<T> data = new LinkedList<>();
				for(Map<String,Object> map : list){
					T bean = clazz.newInstance();
					BeanUtils.populate(bean, map);
					data.add(bean);
				}
				return data;
			}	
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static <T> T populate(Map<String,Object> map,Class<T> clazz){
		if(clazz == null){
			throw new NullPointerException("clazz参数不能为空");
		}
		try{
			T bean = clazz.newInstance();
			BeanUtils.populate(bean,map);	
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
