package ruanko.activity.bopo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//好友界面（Friend）
public class Friend extends Bottom{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend);
	}
	
	//添加按钮点击事件
	public void onClick_Add(View view){
		Intent intent = new Intent(this,Friend_Add.class);
		startActivity(intent);
	}
}
