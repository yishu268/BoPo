package ruanko.activity.bopo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//成长信息添加界面（Node_Add）
public class Node_Add extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.node_add);
	}
	//完成按钮点击事件
	public void onClick_Finish(View view){
		Intent intent = new Intent(this,Node_View.class);
		startActivity(intent);
		finish();
	}
}
