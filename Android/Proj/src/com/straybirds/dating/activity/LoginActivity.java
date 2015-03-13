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
import com.straybirds.dating.network.NetUtils;

public class LoginActivity extends Activity implements OnClickListener {

	Button button;
	EditText et_UserName;
	EditText et_Password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);
		button = (Button) findViewById(R.id.bt_login);
		button.setOnClickListener(this);

		et_UserName = (EditText) findViewById(R.id.et_username);
		et_Password = (EditText) findViewById(R.id.et_password);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_login:

			final String username = et_UserName.getText().toString();
			final String password = et_Password.getText().toString();

			if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
				Toast.makeText(LoginActivity.this, "用户名或者密码不能为空",
						Toast.LENGTH_SHORT).show();
			} else {

				new Thread(new Runnable() {

					@Override
					public void run() {
						final String state = NetUtils.loginOfPost(username,
								password, LoginActivity.this);

						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								if (state != null) {
									// TODO 登陆成功需要保存token
									
									Intent i = new Intent(LoginActivity.this,
											MainInterfaceActivity.class);
									startActivity(i);
								} else {
//									Toast.makeText(LoginActivity.this,
//											"用户名或者密码不正确", Toast.LENGTH_SHORT)
//											.show();
								}
							}
						});

					}
				}).start();
			}
			break;

		default:
			break;
		}
	}

}
