package com.straybirds.dating.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.straybirds.dating.R;
import com.straybirds.dating.activity.DateDetailsActivity;
import com.straybirds.dating.base.BaseListView;
import com.straybirds.dating.base.MyAdapter;
import com.straybirds.dating.view.DatingListView.Adapter;
import com.straybirds.dating.view.DatingListView.ViewHolder;

public class PublishDateListView extends BaseListView {

	final Context context;
	private List<Map<String, Object>> mData;
	public PublishDateListView(final Context context, AttributeSet attrs) {
		super(context);
		this.context = context;
		mData = initData();
		Adapter adapter = new Adapter(context);
		adapter.setData(mData);
		setAdapter(adapter);
		this.setDividerHeight(MEASURED_HEIGHT_STATE_SHIFT);
		this.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent i = new Intent(context, DateDetailsActivity.class);
				context.startActivity(i);
			}
		});
	}

	@Override
	public List<Map<String, Object>> initData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();

		map = new HashMap<String, Object>();
		map.put("itemName", "标题");
		map.put("itemContent", "请填写");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("itemName", "内容");
		map.put("itemContent", "请填写");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("itemName", "开始时间");
		map.put("itemContent", "请选择");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("itemName", "结束时间");
		map.put("itemContent", "请选择");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("itemName", "人数");
		map.put("itemContent", "请选择");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("itemName", "地点");
		map.put("itemContent", "请填写");
		list.add(map);
		
		
		
		return list;
	}

	public final class ViewHolder {
		TextView itemName;
		TextView itemContent;
	}
	public class Adapter extends MyAdapter{

		public Adapter(Context context) {
			super(context);
			
		}

		@Override
		public View initViewByPositionAndHolder(int position, View convertView,
				ViewGroup parent) {
			ViewHolder holder = null;
			if (convertView == null) {
				
				holder=new ViewHolder();  
/*				 ViewHolder用于listview加载性能优化
				当处理一些耗时的资源加载的时候需要做到以下几点，以使你的加载更快更平滑：
				1.   适配器在界面主线程中进行修改
				2.   可以在任何地方获取数据但应该在另外一个地方请求数据
				3.   在主界面的线程中提交适配器的变化并调用notifyDataSetChanged()方法*/
				
				
				convertView = getInflater().inflate(R.layout.publish_date_list_item, null);
				holder.itemContent =(TextView)convertView.findViewById(R.id.tv_item_content);
				holder.itemName = (TextView)convertView.findViewById(R.id.tv_item_name);
				
				convertView.setTag(holder);
				
			}else {
				
//				View中的setTag（Onbect）表示给View添加一个格外的数据，以后可以用getTag()将这个数据取出来。
//				可以用在多个Button添加一个监听器，每个Button都设置不同的setTag。
//				这个监听器就通过getTag来分辨是哪个Button 被按下。
				
				holder = (ViewHolder)convertView.getTag();
				
			}

			
			holder.itemContent.setText((String) mData.get(position).get("itemContent"));
			holder.itemName.setText((String)mData.get(position).get("itemName"));
			
			return convertView;
		}

			
		}
		
	}
