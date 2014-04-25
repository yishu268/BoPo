package ruanko.activity.bopo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//添加好友界面（Friend_Add）
public class Friend_Add extends Bottom{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_add);
	}
	
	//返回按钮点击事件
	public void onClick_Back(View view){
		Intent intent = new Intent(this,Friend.class);
		startActivity(intent);
		finish();
	}
	//添加好友按钮点击事件
	public void onClick_Add_Name(View view){
		Intent intent = new Intent(this,Friend_Add_Name.class);
		startActivity(intent);
	}
	//按条件搜索按钮点击事件
	public void onClick_Add_Condition(View view){
		Intent intent = new Intent(this,Friend_Add_Condition.class);
		startActivity(intent);
	}
}
