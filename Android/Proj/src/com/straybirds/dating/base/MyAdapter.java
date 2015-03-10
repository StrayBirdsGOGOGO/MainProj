package com.straybirds.dating.base;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract  class MyAdapter extends BaseAdapter {

	private LayoutInflater Inflater;
	public LayoutInflater getInflater() {
		return Inflater;
	}

	public void setInflater(LayoutInflater inflater) {
		Inflater = inflater;
	}

	private List<Map<String, Object>> data;
	
	public List<Map<String, Object>> getData() {
		return data;
	}

	public void setData(List<Map<String, Object>> data) {
		this.data = data;
	}

	public MyAdapter(Context context) {
		// LayoutInflater是用来找res/layout/下的xml布局文件，并且实例化
		this.Inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return initViewByPositionAndHolder( position,  convertView, parent);
		 
	}

	//需要自己根据界面定义holder
	public abstract View initViewByPositionAndHolder(int position, View convertView, ViewGroup parent);

}
