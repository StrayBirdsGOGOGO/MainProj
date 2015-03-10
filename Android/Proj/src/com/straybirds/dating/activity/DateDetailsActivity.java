package com.straybirds.dating.activity;

import com.straybirds.dating.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class DateDetailsActivity extends Activity implements OnClickListener {
	ImageButton buttonBack;
	Button buttonJoin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.date_details);
		buttonBack= (ImageButton) findViewById(R.id.ibt_back);
		buttonJoin=(Button) findViewById(R.id.bt_join);
		
		buttonBack.setOnClickListener(this);
		buttonJoin.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ibt_back:
			finish();
			break;
		case R.id.bt_join:
			Intent i = new Intent(this, JoinDateActivity.class);
			this.startActivity(i);
			break;
		default:
			break;
		}
	}
}
