package ruanko.activity.bopo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//个人信息修改界面（Info_Change）
public class Info_Change extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info_change);
	}
	
	//头像按钮点击事件
	public void onClick_Head(View view){
		Intent intent = new Intent(this,Info_Head.class);
		startActivity(intent);
	}
	//返回按钮点击事件
	public void onClick_Back(View view){
		Intent intent = new Intent(this,Info.class);
		startActivity(intent);
		finish();
	}
}
