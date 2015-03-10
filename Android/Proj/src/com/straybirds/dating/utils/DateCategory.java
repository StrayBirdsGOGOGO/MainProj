package com.straybirds.dating.utils;

public enum DateCategory {
	/*
	 * 约会类型枚举
	 */
	DATE_CATEGORY_EXERCISE("aa",1),DATE_CATEGORY_MOVIE("bb",2),
	DATE_CATEGORY_MEAL("cc",3),DATE_CATEGORY_TRAVEL("dd",4);
	
	// 构造方法
    private DateCategory(String category, int index) {
        this.category = category;
        this.index = index;
    }
    private String category;
    public String getCategory() {
		return category;
	}
	public int getIndex() {
		return index;
	}
	private int index;
    public static void main(String args[]){
    	DateCategory a = DATE_CATEGORY_EXERCISE;
    	System.out.println(a.getCategory());
    }
}
