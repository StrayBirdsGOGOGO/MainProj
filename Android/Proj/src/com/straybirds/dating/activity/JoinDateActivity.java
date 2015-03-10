package com.straybirds.dating.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.straybirds.dating.R;

public class JoinDateActivity extends Activity implements OnClickListener {
	TextView textViewFinish;
	ImageButton buttonBack;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.join_date);
		
		textViewFinish= (TextView) findViewById(R.id.tv_join_finish);
		textViewFinish.setClickable(true);
		textViewFinish.setFocusable(true);
		textViewFinish.setOnClickListener(this);
		
		buttonBack= (ImageButton) findViewById(R.id.ibt_join_back);
		buttonBack.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_join_finish:
			Toast.makeText(this, "发送成功！", Toast.LENGTH_SHORT).show();
			this.finish();
			break;
		case R.id.ibt_join_back:
			this.finish();
			break;
		default:
			break;
		}
	}
}
