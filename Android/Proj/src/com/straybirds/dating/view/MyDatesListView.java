package com.straybirds.dating.view;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.straybirds.dating.R;
import com.straybirds.dating.activity.DateDetailsActivity;
import com.straybirds.dating.base.BaseListView;
import com.straybirds.dating.base.MyAdapter;

public class MyDatesListView extends BaseListView{

	public MyDatesListView(final Context context) {
		super(context);
		setmData(initData());
		Adapter adapter = new Adapter(context);
		adapter.setData(getmData());
		setAdapter(adapter);
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
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public final class ViewHolder {

		public ImageView dateImage;
		public TextView dateTitle;
		public TextView datePlace;
		public TextView dateTime;
		public TextView dateLables;
		public TextView datePersonNumber;
		public int datefavorites;

		public ImageView ownerheadPortrait;
		public TextView ownerNickName;
		public ImageView ownerSex;
		public ImageView ownerCreditClass;
	}
	
	public class Adapter extends MyAdapter {

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
				
				
				convertView = getInflater().inflate(R.layout.date_list_item, null);
				holder.dateImage = (ImageView)convertView.findViewById(R.id.iv_dateimge);
				holder.datePersonNumber = (TextView)convertView.findViewById(R.id.tv_datepersonnumber);
				holder.dateTitle = (TextView)convertView.findViewById(R.id.tv_datetitle);
				holder.dateLables = (TextView)convertView.findViewById(R.id.tv_lable_exercise);
				holder.dateTime = (TextView)convertView.findViewById(R.id.tv_datetime);
				holder.datePlace = (TextView)convertView.findViewById(R.id.tv_dateplace);
				
				holder.ownerCreditClass = (ImageView)convertView.findViewById(R.id.iv_creditclass);
				holder.ownerNickName = (TextView)convertView.findViewById(R.id.tv_nickname);
				holder.ownerSex = (ImageView)convertView.findViewById(R.id.iv_sex);
				holder.ownerheadPortrait = (ImageView)convertView.findViewById(R.id.iv_personalimage);
				convertView.setTag(holder);
				
			}else {
				
//				View中的setTag（Onbect）表示给View添加一个格外的数据，以后可以用getTag()将这个数据取出来。
//				可以用在多个Button添加一个监听器，每个Button都设置不同的setTag。
//				这个监听器就通过getTag来分辨是哪个Button 被按下。
				
				holder = (ViewHolder)convertView.getTag();
				
			}
			
			List<Map<String, Object>> data = getData();
			
			holder.dateImage.setBackgroundResource((Integer) data.get(position).get("dateImage"));
			holder.dateTitle.setText((String)data.get(position).get("dateTitle"));
			holder.dateLables.setText((String)data.get(position).get("dateTitle"));
			holder.dateTime.setText((String)data.get(position).get("dateTime"));
			holder.datePersonNumber.setText((String)data.get(position).get("datePersonNumber"));
			holder.datePlace.setText((String)data.get(position).get("datePlace"));
			
			holder.ownerCreditClass.setBackgroundResource((Integer) data.get(position).get("ownerCreditClass"));
			holder.ownerNickName.setText((String)data.get(position).get("ownerNickName"));;
			holder.ownerSex.setBackgroundResource((Integer) data.get(position).get("ownerSex"));
			holder.ownerheadPortrait.setBackgroundResource((Integer) data.get(position).get("ownerheadPortrait"));
			return convertView;
		}

	}
}
