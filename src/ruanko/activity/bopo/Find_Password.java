package ruanko.activity.bopo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

//找回密码界面（Find_Password）
public class Find_Password extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.find_password);
	}
	//返回按钮点击事件
	public void onClick_Back(View view){
		finish();
	}
}
