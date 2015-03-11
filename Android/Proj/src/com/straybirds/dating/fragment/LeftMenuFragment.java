package com.straybirds.dating.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.straybirds.dating.R;
import com.straybirds.dating.activity.MainInterfaceActivity;

public class LeftMenuFragment extends Fragment implements OnItemClickListener {

	private View view;
	private String tag = "MenuFragment";

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		Log.i(tag, "onActivityCreated");
		ListView list_view = (ListView) view.findViewById(R.id.list_view);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, android.R.id.text1,
				initData());
		list_view.setAdapter(adapter);
		list_view.setOnItemClickListener(this);
	}

	private List<String> initData() {
		List<String> list = new ArrayList<String>();
		list.add("首页");
		list.add("个人中心");
		list.add("通知和消息");
		list.add("发起活动");
		list.add("我的约");
		list.add("我的状态");
		list.add("我的分享");
		list.add("设置");
		return list;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.i(tag, "onCreate");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		Log.i(tag, "onCreateView");
		view = LayoutInflater.from(getActivity()).inflate(R.layout.list_view,
				null);
		return view;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Fragment f  = null;
		switch (position) {
		case 0:
			f  =new HomeFragment();
			break;
			
		case 1:
			f  =new UserCenter();
			break;
			
		case 2:
			f  =new SystemMessageFragment();
			break;
		case 3:
			f  =new PublishDateFrament();
			break;
		case 4:
			f  =new MydatesFragment();
			break;
		case 5:
			f  =new Fragment5();
			break;
		}
        switchFragment(f);
	}
	private void switchFragment(Fragment f) {
		// TODO Auto-generated method stub
		if(f != null){
			if(getActivity() instanceof MainInterfaceActivity){
				((MainInterfaceActivity)getActivity()).switchFragment(f);
			}
		}
	}

}
