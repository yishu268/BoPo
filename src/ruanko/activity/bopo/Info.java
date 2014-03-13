package ruanko.activity.bopo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//个人信息界面（Info）
public class Info extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info);
	}
	
	//修改按钮点击事件
	public void onClick_Change(View view){
		Intent intent = new Intent(this,Info_Change.class);
		startActivity(intent);
	}
	//返回按钮点击事件
	public void onClick_Back(View view){
		Intent intent = new Intent(this,Line.class);
		startActivity(intent);
		finish();
	}
}
