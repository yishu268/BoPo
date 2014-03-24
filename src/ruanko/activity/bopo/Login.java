package ruanko.activity.bopo;

import ruanko.service.bopo.Service_User;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

//登录界面（Login）
public class Login extends Activity {

	//声明控件
	private EditText user = null;
	private EditText password = null;
	
	private Service_User service_User = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		service_User = new Service_User(this);
		init();
	}
	
	//登录按钮点击事件
	public void onClick_Login(View view){
		getContent();
		//Intent intent = new Intent(this,Line.class);
		//startActivity(intent);
		//finish();
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
	//初始化控件
	private void init() {
		user = (EditText)findViewById(R.id.user);
		password = (EditText)findViewById(R.id.password);
	}
	//获取信息
	private void getContent(){
		String user_db = user.getText().toString();
		String password_db = password.getText().toString();
		boolean flag = service_User.login(user_db,password_db);
		//Toast.makeText(this, flag, Toast.LENGTH_SHORT).show();
		//boolean flag = true;
		if (flag) {
			Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(this,Line.class);
			startActivity(intent);
			finish();
		}else {
			Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
		}
	}
	
}
