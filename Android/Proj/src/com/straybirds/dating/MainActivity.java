package com.straybirds.dating;



import com.straybirds.dating.activity.LoginActivity;
import com.straybirds.dating.activity.MainInterfaceActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		String token = Configure.getCachedToken(this);
		String phone_num = Configure.getCachedPhoneNum(this);
		
		if (token!=null&&phone_num!=null) {
			Intent i =new Intent(this, MainInterfaceActivity.class);
			i.putExtra(Configure.KEY_TOKEN, token);
			i.putExtra(Configure.KEY_PHONE_NUM, phone_num);
			startActivity(i);
		}else{
			startActivity(new Intent(this, LoginActivity.class));
		}
		finish();
	}

}
