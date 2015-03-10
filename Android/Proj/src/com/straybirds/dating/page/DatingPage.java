package com.straybirds.dating.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.straybirds.dating.R;
import com.straybirds.dating.base.BasePage;
import com.straybirds.dating.view.DatingListView;

public class DatingPage extends BasePage{

	public DatingPage(Context ct) {
		super(ct);
	}

	@Override
	public View initView(LayoutInflater inflater) {
		DatingListView listView =new DatingListView(ct);
		return listView;
	}

	@Override
	public void initData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dateImage", R.drawable.basketball);
		map.put("dateTitle", "打篮球gogogo~");
	}

	

}
