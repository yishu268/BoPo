package ruanko.activity.bopo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//好友成长记录界面（Friend_Node）
public class Friend_Node extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_node);
	}
	//返回按钮点击事件
	public void onClick_Back(View view){
		finish();
	}
	//评论按钮点击事件
	public void onClick_Review(View view){
		Intent intent = new Intent(this,Review_Add.class);
		startActivity(intent);
	}
}
