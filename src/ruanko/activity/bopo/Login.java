package ruanko.activity.bopo;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.content.Intent;

//登陆界面（Login）
public class Login extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
	}
	
	//登录按钮点击事件
	public void onClick_Login(View view){
		Intent intent = new Intent(this,Line.class);
		startActivity(intent);
		finish();
	}	
	//注册按钮点击事件
	public void onClick_Register(View view){
		Intent intent = new Intent(this,Register.class);
		startActivity(intent);
	}
	//找回密码按钮点击事件
	public void onClick_Find(View view){
		Intent intent = new Intent(this,Find_Password.class);
		startActivity(intent);
	}	
}
