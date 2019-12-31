package com.readbook.page;

import java.util.List;

public class Page<T> {
	
	/**当前页码*/
	private long current=1;
	
	/**每页显示数据条数*/
	private long size=20;
	
	/**查询记录总数*/
	private long total;
	
	/**limit开始下标*/
	private long startIndex;
	
	/**limit结束下标*/
	private long endIndex;
	
	/**当前页数据*/
	private List<T> datas;

	public long getCurrent() {
		if(current <= 0){
			current = 1;
		}
		return current;
	}

	public void setCurrent(long current) {
		this.current = current;
	}

	public long getSize() {
		if(size < 0){
			size = 20;
		}
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getTotalPage() {
		if(getTotal() % getSize() == 0L){
			return getTotal() / getSize();
		}else {
			return getTotal() / getSize() + 1;
		}
	}
	
	public long getStartIndex() {
		if(getCurrent() > 0 && getSize() > 0){
			return (getCurrent() - 1) * getSize();
		}
		return startIndex;
	}

	public void setStartIndex(long startIndex) {
		this.startIndex = startIndex;
	}

	public long getEndIndex() {
		if(getCurrent() > 0 && getSize() > 0){
			return (getCurrent() * getSize()) - 1;
		}
		return endIndex;
	}

	public void setEndIndex(long endIndex) {
		this.endIndex = endIndex;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
}
