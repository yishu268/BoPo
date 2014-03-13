package ruanko.activity.bopo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//设置界面（Set）
public class Set extends Bottom{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.set);		
	}
	//数据统计按钮点击事件
	public void onClick_Stat(View view) {
		Intent intent = new Intent(Set.this, Stat.class);
		startActivity(intent);
	}
	//主题设置按钮点击事件
	public void onClick_Theme(View view) {
		Intent intent = new Intent(Set.this, Theme.class);
		startActivity(intent);
	}
	//关于我们按钮点击事件
	public void onClick_About(View view) {
		Intent intent = new Intent(Set.this, About.class);
		startActivity(intent);
	}
	//注销登陆按钮点击事件
	public void onClick_Logout(View view) {
		Intent intent = new Intent(Set.this, Login.class);
		startActivity(intent);
		finish();
	}
}
