package ruanko.activity.bopo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//成长信息界面（Node_View）
public class Node_View extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.node_view);
	}
	//返回按钮点击事件
	public void onClick_Back(View view){
		Intent intent = new Intent(this,Line.class);
		startActivity(intent);
		finish();
	}
	//编辑按钮点击事件
	public void onClick_Edit(View view){
		Intent intent = new Intent(this,Node_Change.class);
		startActivity(intent);
	}
	//删除按钮点击事件
	public void onClick_Delete(View view){
		Intent intent = new Intent(this,Line.class);
		startActivity(intent);
		finish();
	}
	//评论按钮点击事件
	public void onClick_Review(View view){
		Intent intent = new Intent(this,Review_Add.class);
		startActivity(intent);
	}
}
