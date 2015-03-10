package com.straybirds.dating.base;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public abstract class BaseListView extends ListView {
	
	public BaseListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.context = context;
	}
	
	public BaseListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
	}
	public BaseListView(Context context) {
		super(context);
		this.context = context;
	}
	List<Map<String, Object>> mData;
	public List<Map<String, Object>> getmData() {
		return mData;
	}
	public void setmData(List<Map<String, Object>> mData) {
		this.mData = mData;
	}
	final Context context;


	public abstract List<Map<String, Object>> initData();
}
