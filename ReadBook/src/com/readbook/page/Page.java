package com.readbook.page;

import java.util.List;

public class Page<T> {
	
	/**当前页码*/
	private long current=1;
	
	/**每页显示数据条数*/
	private long limit=20;
	
	/**查询记录总数*/
	private long total;
	
	/**limit开始下标*/
	private long startIndex;
	
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

	public long getLimit() {
		if(limit < 0){
			limit = 20;
		}
		return limit;
	}

	public void setLimit(long limit) {
		this.limit = limit;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getTotalPage() {
		if(getTotal() % getLimit() == 0L){
			return getTotal() / getLimit();
		}else {
			return getTotal() / getLimit() + 1;
		}
	}
	
	public long getStartIndex() {
		if(getCurrent() > 0 && getLimit() > 0){
			return (getCurrent() - 1) * getLimit();
		}
		return startIndex;
	}

	public void setStartIndex(long startIndex) {
		this.startIndex = startIndex;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
}
