package ruanko.activity.bopo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//好友成长轴界面（Friend_Line）
public class Friend_Line extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_line);
	}
	//返回按钮点击事件
	public void onClick_Back(View view){
		finish();
	}
	//好友成长信息按钮点击事件
	public void onClick_Node(View view){
		Intent intent = new Intent(this,Friend_Node.class);
		startActivity(intent);
	}
}
