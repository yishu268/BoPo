package ruanko.activity.bopo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//成长轴界面（Line）
public class Line extends Bottom{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.line);
	}
	//头像按钮点击事件
	public void onClick_Info(View view){
		Intent intent = new Intent(this,Info.class);
		startActivity(intent);
	}
	//添加按钮点击事件
	public void onClick_Add(View view){
		Intent intent = new Intent(this,Node_Add.class);
		startActivity(intent);
	}
}
