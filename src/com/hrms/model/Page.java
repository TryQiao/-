package com.hrms.model;

public class Page {
	private int pageIndex = 1;//要查询的页码
	private int pageSize = 6;//每页查询的记录数
	private int pageCount;//总页数
	private long totalCount;//总记录数
	private int recordStart;//sql查询的偏移量
	private String url;//请求地址
	//..还可以扩展其他信息
	
	
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount = (int)(totalCount%pageSize==0? totalCount/pageSize: totalCount/pageSize+1);
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public int getRecordStart() {
		if(pageIndex<1) {
			pageIndex = 1;
		}
		if(pageIndex>getPageCount()) {
			pageIndex = getPageCount();
		}
		return (pageIndex-1)* pageSize;
	}
	public void setRecordStart(int recordStart) {
		this.recordStart = recordStart;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
