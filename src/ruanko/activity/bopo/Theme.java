package ruanko.activity.bopo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

//主题界面（Theme）
public class Theme extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.theme);
	}
	
	//返回按钮点击事件
	public void onClick_Back(View view){
		finish();
	}
}
