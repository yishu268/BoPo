package ruanko.activity.bopo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//按条件添加好友界面（Friend_Add_Condition）
public class Friend_Add_Condition extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_add_condition);
	}
	//返回按钮点击事件
	public void onClick_Back(View view){
		Intent intent = new Intent(this,Friend_Add.class);
		startActivity(intent);
		finish();
	}
	//搜索按钮点击事件
	public void onClick_Search(View view){
		Intent intent = new Intent(this,Friend_Add_Result.class);
		startActivity(intent);
		finish();
	}
}
