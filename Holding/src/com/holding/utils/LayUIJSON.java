package com.holding.utils;

import java.util.ArrayList;
import java.util.List;

	public class LayUIJSON<Menu> {
		 
	    private int code=0;
	    private String msg;
	    private Long count; //总条数
	    private List<Menu> data = new ArrayList(); //装前台当前页的数据
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
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
		public List<Menu> getData() {
			return data;
		}
		public void setData(List<Menu> data) {
			this.data = data;
		}
	    
	 
	}
