package ruanko.activity.bopo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//头像选择界面（Info_Head）
public class Info_Head extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info_head);
	}
	
	//返回按钮点击事件
	public void onClick_Back(View view){
		Intent intent = new Intent(this,Info_Change.class);
		startActivity(intent);
		finish();
	}
}
