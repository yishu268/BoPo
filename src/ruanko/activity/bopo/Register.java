package ruanko.activity.bopo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//注册界面（Register）
public class Register extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
	}
	//返回按钮点击事件
	public void onClick_Back(View view) {
		Intent intent = new Intent(this,Login.class);
		startActivity(intent);
		finish();
	}
	//注册按钮点击事件
	public void onClick_Register(View view) {
		Intent intent = new Intent(this,Login.class);
		startActivity(intent);
		finish();
	}
}
