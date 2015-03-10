package com.straybirds.dating.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.straybirds.dating.R;

public class LoginActivity extends Activity implements OnClickListener {

	Button button;
	EditText username;
	EditText password;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);
		button = (Button) findViewById(R.id.bt_login);
		button.setOnClickListener(this);
		
		username = (EditText) findViewById(R.id.et_username);
		password = (EditText) findViewById(R.id.et_password);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_login:
			if (TextUtils.isEmpty(username.getText())||TextUtils.isEmpty(password.getText())) {
				Toast.makeText(LoginActivity.this,"用户名或者密码不能为空", Toast.LENGTH_SHORT).show();
			}else if(username.getText().toString().equals("xcm")&&password.getText().toString().equals("123")){
				//TODO 登陆成功需要保存token
				
				Intent i =new Intent(this, MainInterfaceActivity.class);
				startActivity(i);
			}else{
				Toast.makeText(LoginActivity.this,"用户名或者密码不正确", Toast.LENGTH_SHORT).show();
			}
			break;

		default:
			break;
		}
	}
	
}
