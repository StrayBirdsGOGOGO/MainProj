package com.straybirds.dating;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.straybirds.dating.activity.LoginActivity;
import com.straybirds.dating.activity.LogoActivity;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		SharedPreferences sharedPreferences = getSharedPreferences("userInfo",
				Activity.MODE_PRIVATE);

		// 使用getString方法获得value，注意第2个参数是value的默认值
		String userName = sharedPreferences.getString("USER_NAME", "");
		String password = sharedPreferences.getString("PASSWORD", "");

		Toast.makeText(this, "读取数据如下："+"\n"+"userName：" + userName + "\n" + "password：" + password, 
				Toast.LENGTH_LONG).show();
		
		if (!userName.equals("") && !password.equals("")) {
			Intent i = new Intent(this, LogoActivity.class);
			startActivity(i);
		} else {
			startActivity(new Intent(this, LoginActivity.class));
		}
		finish();
	}

}
